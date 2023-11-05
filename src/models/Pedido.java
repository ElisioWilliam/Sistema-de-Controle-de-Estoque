package models;

public class Pedido {
	private int id;
    private int id_produto;
    private String documento_pessoa;
    private int quantidade_produto;
    private float valor_total;
   
	public Pedido(int id, int id_produto , String documento_pessoa, int quantidade_produto, float valor_total) {
	   this.id = id;
	   this.id_produto = id_produto;
	   this.documento_pessoa = documento_pessoa;
	   this.quantidade_produto = quantidade_produto;
	   this.valor_total = valor_total;
	}
	
	public Pedido(int id_produto , String documento_pessoa, int quantidade_produto, float valor_total) {
		   this.id_produto = id_produto;
		   this.documento_pessoa = documento_pessoa;
		   this.quantidade_produto = quantidade_produto;
		   this.valor_total = valor_total;
	}
	
	public int getId(){
	   return id;
	}
		
	public void setId(int id){
	   this.id= id;
	}
		
	public int getIdProduto(){
	   return id_produto;
	}
	
	public void setIdProduto(int id_produto){
	   this.id_produto = id_produto;
	}
	
	public String getDocumentoPessoa(){
	    return documento_pessoa;
	}
	
	public void setDocumentoPessoa(String documento_pessoa){
	    this.documento_pessoa = documento_pessoa;
	}
	
	public int getQuantidadeProduto(){
	    return quantidade_produto;
	}
	
	public void setQuantidadeProduto(int quantidade_produto){
	    this.quantidade_produto = quantidade_produto;
	}
	
	public float getValorTotal(){
	    return valor_total;
	}
	
	public void setValorTotal(float valor_total){
	    this.valor_total = valor_total;
	}
	
}