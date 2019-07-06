package lania.edu.mx.sicosvac.Fragmentos;


import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import lania.edu.mx.sicosvac.R;
import lania.edu.mx.sicosvac.SplashActivity;
import lania.edu.mx.sicosvac.db.APIService;
import lania.edu.mx.sicosvac.db.pojo.Menor;
import lania.edu.mx.sicosvac.general.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MenoresFragment extends Fragment {
    private static Context context = null;

    public static MenoresFragment newInstance(String param1, String param2) {
        MenoresFragment fragment = new MenoresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_menores,container,false);
        context = getContext();

        final LinearLayout menoresContainer = view.findViewById(R.id.container_fragment_menores);
        menoresContainer.removeAllViews();

        final int tutorId = getActivity().getIntent().getIntExtra("tutor_id",0);

        APIService apiService = RetrofitClient.getApiService();
        Call<List<Menor>> menoresCall = apiService.getMenores(tutorId);

        menoresCall.enqueue(new Callback<List<Menor>>() {
            @Override
            public void onResponse(Call<List<Menor>> call, Response<List<Menor>> response) {
                if (response.code() == 200) {
                    for (final Menor m : response.body()) {
                        View rowView = getLayoutInflater().inflate(R.layout.menor_item, null, true);

                        ((TextView) rowView.findViewById(R.id.menorNombre)).setText(m.getNombre() + " " + m.getApellidos());
                        ((TextView) rowView.findViewById(R.id.menorCURP)).setText(m.getCurp());
                        ((TextView) rowView.findViewById(R.id.dateText)).setText(m.getFecha_nac());

                        menoresContainer.addView(rowView);
                    }



                } else if (response.code() == 401) { // somehow credentials are not valid any more. For example, pwd or username are changed manually in the database. Should never happen
                    SplashActivity.logout(getActivity());
                }
            }
            @Override
            public void onFailure(Call<List<Menor>> call, Throwable t) {
                SplashActivity.showSimpleAlertDialog("Verifica tu conexión y vuelve a intentarlo", getActivity());
            }
        });

        return view;
    }

}
