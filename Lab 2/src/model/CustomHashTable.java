package model;

public class CustomHashTable {
	private String[] table;
	private int numElemens;
	
	public CustomHashTable(int size) {
		this.numElemens=0;
		if(!isPositivePrime(size)) {
			size=nextPrimeNumber(size);
		}
		this.table=new String[size];
	}
	
	public String[] getSymTable() {
		return table;
	}
	
	public int getNumOfElems() {
		return numElemens;
	}
	
	public int getSize() {
		return table.length;
	}
	
	public int insert(String identifier) {
		if(identifier==null) {
			return -2;
		}else if(find(identifier)!=-1) {
			return -1;
		}
		int pos=fHash(identifier);
		int intento=0;
		while(intento<getSize() && table[pos]!=null) {
			pos=buscaPosicion(identifier,intento);
			intento++;
		}
		if(intento==getSize()) {
			return -3;
		}else {
			table[pos]=identifier;
			numElemens++;
			return 0;
		}
	}
	
	private int buscaPosicion(String identifier, int intento) {
		return (fHash(identifier)+intento)%getSize();
	}
	
	public int find(String identifier) {
		int pos=0;
		int intento=0;
		while(intento<=getSize()) {
			pos = buscaPosicion(identifier, intento);
			if(table[pos]!=null && table[pos].equals(identifier)) {
				return pos;
			}
			intento++;
		}
		return -1;
	}

	public String toString() {
		StringBuilder cadena = new StringBuilder();
		for(int i=0;i< getSize();i++){
			if(table[i]==null) {
				cadena.append("-");
			}else {
				cadena.append(table[i].toString());
			}
			cadena.append(";");
		}
		cadena.append("[Size: ");
		cadena.append(getSize());
		cadena.append(" Num.Elems.: ");
		cadena.append(getNumOfElems());
		cadena.append("]");
		return cadena.toString();
	}
	
 	private int fHash(String identifier) {
		int pos = identifier.hashCode()%getSize();
		if(pos<0) {
			return pos + getSize();
		}else {
			return pos;
		}
	}
	
	private boolean isPositivePrime(int numero) {
		if(numero<0) {
			return false;
		}
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=numero)){
			if (numero % contador == 0) {
				primo = false;
			}
			contador++;
		}
		return primo;
	} 
	
	private int nextPrimeNumber(int numero) {
		if(isPositivePrime(numero)) {
			numero++;
		}
		while(!isPositivePrime(numero)) {
			numero++;
		}
		return numero;
	}
	
}