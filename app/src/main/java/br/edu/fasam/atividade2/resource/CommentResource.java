package br.edu.fasam.atividade2.resource;

import java.util.List;

import br.edu.fasam.atividade2.model.Comment;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CommentResource {

    @GET("comments")
    Call<List<Comment>> get();

    @GET("comments/{id}")
    Call<Comment> get(Integer id);

    @POST("comments")
    Call<Comment> post(@Body Comment comment);

    @PUT("comments/{id}")
    Call<Comment> put(@Body Comment comment);

    @PATCH("comments/{id}")
    Call<Comment> patch(@Body Comment comment);

    @DELETE("comments/{id}")
    Call<Void> delete(Integer id);
}
