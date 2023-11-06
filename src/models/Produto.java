package models;

public class Produto {
	private int id;
    private String nome;
    private String codigo;
    private int quantidade;
    private float preco;

	public Produto(int id, String nome, String codigo, int quantidade, float preco){
		this.id = id;
	    this.nome = nome;
	    this.codigo = codigo;
	    this.quantidade = quantidade;
	    this.preco = preco;
	}
	public Produto(String nome, String codigo, int quantidade, float preco){
	    this.nome = nome;
	    this.codigo = codigo;
	    this.quantidade = quantidade;
	    this.preco = preco;
	}
	public int getId(){
		   return id;
		}
	public void setId(int id){
	   this.id= id;
	}
	public String getNome(){
	    return nome;
    }
	public void setNome(String nome) {
	    this.nome = nome;
    }
	public String getCodigo(){
	    return codigo;
    }
	public void setCodigo(String codigo){
	    this.codigo = codigo;
    }
	public int getQuantidade(){
	    return quantidade;
    }
	public void setQuantidade(int quantidade){
	    this.quantidade = quantidade;
    }
	public float getPreco(){
	    return preco;
    }
	public void setPreco(float preco){
	    this.preco = preco;
    }
}