package br.edu.fasam.atividade2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.edu.fasam.atividade2.R;
import br.edu.fasam.atividade2.adapter.CommentAdapter;
import br.edu.fasam.atividade2.boostrap.APIClient;
import br.edu.fasam.atividade2.model.Comment;
import br.edu.fasam.atividade2.resource.CommentResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CommentActivity extends AppCompatActivity {

    private Retrofit retrofit;

    private CommentResource commentResource;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
    }

    public void listar(View view) {

        retrofit = APIClient.getClient();

        commentResource = retrofit.create(CommentResource.class);
        Call<List<Comment>> get = commentResource.get();

        get.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                List<Comment> commments = response.body();

                CommentAdapter adapter = new CommentAdapter(getApplicationContext(), commments);

                listView = findViewById(R.id.listView);

                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_LONG).show();

                Log.e("fasam", t.getMessage());

            }
        });

    }
}