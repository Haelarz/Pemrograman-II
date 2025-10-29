package Modul4.prak402;

public class Anjing extends Pet {
	private String warnaBulu;
	private String[] kemampuan;
	
	Anjing(String r, String n, String w, String[] k) {
		super(r, n);
		setWarnaBulu(w);
		setKemampuan(k);
	}
	
	public void displayDetailAnjing(){
		super.display();
		System.out.printf("Warna Bulu: %s\n", getWarnaBulu());
		System.out.print("Kemampuan : ");
		for(String k: getKemampuan()) System.out.printf("%s", k);
		System.out.print("\n");
	}
	
	public String getWarnaBulu() {
		return warnaBulu;
	}

	public void setWarnaBulu(String warnaBulu) {
		this.warnaBulu = warnaBulu;
	}

	public String[] getKemampuan() {
		return kemampuan;
	}

	public void setKemampuan(String[] kemampuan) {
		this.kemampuan = kemampuan;
	}
}
