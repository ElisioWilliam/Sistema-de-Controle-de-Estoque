package models;

public class Pedido {
	private int id;
    private int id_produto;
    private int id_pessoa;
    private int quantidade_produto;
    private float valor_total;
   
	public Pedido(int id, int id_produto , int id_pessoa, int quantidade_produto, float valor_total) {
	   this.id = id;
	   this.id_produto = id_produto;
	   this.id_pessoa = id_pessoa;
	   this.quantidade_produto = quantidade_produto;
	   this.valor_total = valor_total;
	}
	
	public int getId(){
		   return id;
		}
		
	public void setId(int id){
	   this.id= id;
	}
		
	public int getId_produto(){
	   return id_produto;
	}
	
	public void setId_produto(int id_produto){
	   this.id_produto = id_produto;
	}
	
	public int getId_pessoa(){
	    return id_pessoa;
	}
	
	public void setId_pessoa(int id_pessoa){
	    this.id_pessoa = id_pessoa;
	}
	
	public int getQuantidade_produto(){
	    return quantidade_produto;
	}
	
	public void setQuantidade_produto(int quantidade_produto){
	    this.quantidade_produto = quantidade_produto;
	}
	
	public float getValor_total(){
	    return valor_total;
	}
	
	public void setValor_total(float valor_total){
	    this.valor_total = valor_total;
	}
	
}
