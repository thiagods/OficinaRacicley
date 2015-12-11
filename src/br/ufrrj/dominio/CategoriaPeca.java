package br.ufrrj.dominio;

public enum CategoriaPeca {
	
	
	MOTOR("motor"), LANTERNAGEM("lanternagem"), ELETRICO("eletrico");
	private String nome;
	
	CategoriaPeca(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public static CategoriaPeca find(String nome){
		
		for(CategoriaPeca categoria : CategoriaPeca.values()){
			if(categoria.getNome().equals(nome))
				return categoria;
		}
		return null;
	}
	
}
