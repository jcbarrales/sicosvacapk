package lania.edu.mx.sicosvac.Fragmentos;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import lania.edu.mx.sicosvac.R;
import lania.edu.mx.sicosvac.SplashActivity;
import lania.edu.mx.sicosvac.db.APIService;
import lania.edu.mx.sicosvac.db.pojo.notificacion;
import lania.edu.mx.sicosvac.General.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificacionesFragment extends Fragment {

    private static Context context = null;

    public static NotificacionesFragment newInstance(String param1, String param2) {
        NotificacionesFragment fragment = new NotificacionesFragment();
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
        View view = inflater.inflate(R.layout.fragment_notificaciones,container,false);
        context = getContext();

        final LinearLayout notificacionesContainer = view.findViewById(R.id.container_fragment_notificaciones);
        notificacionesContainer.removeAllViews();

        final int tutorId = getActivity().getIntent().getIntExtra("tutor_id",0);

        APIService apiService = RetrofitClient.getApiService();
        Call<List<notificacion>> notificacionesCall = apiService.getNotificaciones(tutorId);

        notificacionesCall.enqueue(new Callback<List<notificacion>>() {
            @Override
            public void onResponse(Call<List<notificacion>> call, Response<List<notificacion>> response) {
                if (response.code() == 200) {
                    for (final notificacion n : response.body()) {
                        View rowView = getLayoutInflater().inflate(R.layout.notificacion_item, null, true);
                        TextView estadoVacuna = new TextView(context);
                        TextView Descripcion = new TextView(context);

                        if (n.getDiasvencidos() == 1) {
                            estadoVacuna.setText("Vacuna vencida");
                            Descripcion.setText("La vacuna del menor " + n.getMenornombre() + " lleva " +  n.getDias() + " días vencida.");
                        } else if (n.getDiasvencidos() == 2) {
                            estadoVacuna.setText("Vacuna por vencer");
                            Descripcion.setText("La vacuna del menor " + n.getMenornombre() + " está por vencer.");
                        }

                        /*if (n.getDiasvencidos() == 1)
                        { ((TextView) rowView.findViewById(R.id.tipoVacuna)).setTextColor(0X903532); }
                        else{ ((TextView) rowView.findViewById(R.id.tipoVacuna)).setTextColor(0X73c253); }*/
                        ((TextView) rowView.findViewById(R.id.tipoVacuna)).setText(estadoVacuna.getText());

                        ((TextView) rowView.findViewById(R.id.textoVacuna)).setText(Descripcion.getText());

                        notificacionesContainer.addView(rowView);
                    }



                } else if (response.code() == 401) { // somehow credentials are not valid any more. For example, pwd or username are changed manually in the database. Should never happen
                    SplashActivity.logout(getActivity());
                }
            }
            @Override
            public void onFailure(Call<List<notificacion>> call, Throwable t) {
                SplashActivity.showSimpleAlertDialog("Verifica tu conexión y vuelve a intentarlo", getActivity());
            }
        });
        return view;
    }

}
