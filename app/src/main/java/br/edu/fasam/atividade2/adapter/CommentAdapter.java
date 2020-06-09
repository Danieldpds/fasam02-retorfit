package br.edu.fasam.atividade2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fasam.atividade2.R;
import br.edu.fasam.atividade2.model.Comment;

public class CommentAdapter extends BaseAdapter {

    Context context;
    List<Comment> colecao;
    LayoutInflater inflater;

    public CommentAdapter(final Context context, final List<Comment> colecao){
        this.context =  context;
        this.colecao = colecao;
    }

    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);
        }

        Comment comment = (Comment)this.getItem(position);

        TextView name, email, body;

        name = view.findViewById(R.id.txtItemName);
        email = view.findViewById(R.id.txtItemEmail);
        body = view.findViewById(R.id.txtItemComentario);

        name.setText(comment.getName());
        email.setText(comment.getEmail());
        body.setText(comment.getBody());

        return view;
    }
}
