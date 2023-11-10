package models;

public class Pedido {
	private int id;
    private String codigo_produto;
    private String documento_pessoa;
    private int quantidade_produto;
    private float valor_total;
   
	public Pedido(int id, String codigo_produto , String documento_pessoa, int quantidade_produto, float valor_total) {
	   this.id = id;
	   this.codigo_produto = codigo_produto;
	   this.documento_pessoa = documento_pessoa;
	   this.quantidade_produto = quantidade_produto;
	   this.valor_total = valor_total;
	}
	
	public Pedido(String codigo_produto , String documento_pessoa, int quantidade_produto, float valor_total) {
		   this.codigo_produto = codigo_produto;
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
		
	public String getCodigoProduto(){
	   return codigo_produto;
	}
	
	public void setCodigoProduto(String codigo_produto){
	   this.codigo_produto = codigo_produto;
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