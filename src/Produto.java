import java.util.concurrent.atomic.AtomicInteger;

public class Produto {
	
	
	private static final AtomicInteger contador = new AtomicInteger(0);
	private int codigo;
	private final int setor;
	private final String nome;
	private double preco;
	private int next;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	public int getSetor() {
		return setor;
	}
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	
	public Produto(String nome, int setor, double preco)
	{
		this.nome = nome;
		this.setor = setor;
		this.preco = preco;
		codigo = contador.incrementAndGet();	
	}
	
}
