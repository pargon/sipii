package Beans;

public class bEspacio {

	private int id;
	private String tipo;
	private String calle;
	private String chapa;
	private String estado;
	
	private String tipoCat;
	private int cua;
	private String lat;
	private String longi;
	private float anchoP;
	private float largoP;
	private String canteroE;
	private int esp;
	private String ar_alt;
	private int ar_est;
	private float ar_per;
	private String ar_incl;
	private String ar_ori;
	private String co_dF;
	private String co_cF;
	private String co_Est;
	private String tr_cB;
	private String tr_cM;
	private String tr_cA;
	private String tr_dest;
	private String tr_interf;
	private String ra_dest;
	private String ra_interf;
	private String ar_s;
	private String tr_co;
	private String tr_ab;
	private String tr_desg;
	private String tr_desc;
	private String tr_raj;
	private String tr_fr;
	private String tr_ch;
	private String tr_en;
	private String ra_co;
	private String ra_cr;
	private String ra_mI;
	private String ra_s;
	private String ra_mR;
	private String ra_f;
	private String ra_c;
	private String ra_ex;
	private String ra_b;
	private String ra_ep;
	private String ra_fr;
	private String ra_t;
	
	
	public bEspacio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bEspacio(int id, String tipo, String calle, String chapa,
			String estado) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.calle = calle;
		this.chapa = chapa;
		this.estado = estado;
	}
	
	
	
	
	private bEspacio(int id, String tipo, String calle, String chapa,
			String estado, String tipoCat, int cua, String lat, String longi,
			float anchoP, float largoP, String canteroE, int esp,
			String ar_alt, int ar_est, float ar_per, String ar_incl,
			String ar_ori, String co_dF, String co_cF, String co_Est,
			String tr_cB, String tr_cM, String tr_cA, String tr_dest,
			String tr_interf, String ra_dest, String ra_interf, String ar_s,
			String tr_co, String tr_ab, String tr_desg, String tr_desc,
			String tr_raj, String tr_fr, String tr_ch, String tr_en,
			String ra_co, String ra_cr, String ra_mI, String ra_s,
			String ra_mR, String ra_f, String ra_c, String ra_ex, String ra_b,
			String ra_ep, String ra_fr, String ra_t) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.calle = calle;
		this.chapa = chapa;
		this.estado = estado;
		this.tipoCat = tipoCat;
		this.cua = cua;
		this.lat = lat;
		this.longi = longi;
		this.anchoP = anchoP;
		this.largoP = largoP;
		this.canteroE = canteroE;
		this.esp = esp;
		this.ar_alt = ar_alt;
		this.ar_est = ar_est;
		this.ar_per = ar_per;
		this.ar_incl = ar_incl;
		this.ar_ori = ar_ori;
		this.co_dF = co_dF;
		this.co_cF = co_cF;
		this.co_Est = co_Est;
		this.tr_cB = tr_cB;
		this.tr_cM = tr_cM;
		this.tr_cA = tr_cA;
		this.tr_dest = tr_dest;
		this.tr_interf = tr_interf;
		this.ra_dest = ra_dest;
		this.ra_interf = ra_interf;
		this.ar_s = ar_s;
		this.tr_co = tr_co;
		this.tr_ab = tr_ab;
		this.tr_desg = tr_desg;
		this.tr_desc = tr_desc;
		this.tr_raj = tr_raj;
		this.tr_fr = tr_fr;
		this.tr_ch = tr_ch;
		this.tr_en = tr_en;
		this.ra_co = ra_co;
		this.ra_cr = ra_cr;
		this.ra_mI = ra_mI;
		this.ra_s = ra_s;
		this.ra_mR = ra_mR;
		this.ra_f = ra_f;
		this.ra_c = ra_c;
		this.ra_ex = ra_ex;
		this.ra_b = ra_b;
		this.ra_ep = ra_ep;
		this.ra_fr = ra_fr;
		this.ra_t = ra_t;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getChapa() {
		return chapa;
	}
	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoCat() {
		return tipoCat;
	}
	public void setTipoCat(String tipoCat) {
		this.tipoCat = tipoCat;
	}
	public int getCua() {
		return cua;
	}
	public void setCua(int cua) {
		this.cua = cua;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public float getAnchoP() {
		return anchoP;
	}
	public void setAnchoP(float anchoP) {
		this.anchoP = anchoP;
	}
	public float getLargoP() {
		return largoP;
	}
	public void setLargoP(float largoP) {
		this.largoP = largoP;
	}
	public String getCanteroE() {
		return canteroE;
	}
	public void setCanteroE(String canteroE) {
		this.canteroE = canteroE;
	}
	public int getEsp() {
		return esp;
	}
	public void setEsp(int esp) {
		this.esp = esp;
	}
	public String getAr_alt() {
		return ar_alt;
	}
	public void setAr_alt(String ar_alt) {
		this.ar_alt = ar_alt;
	}
	public int getAr_est() {
		return ar_est;
	}
	public void setAr_est(int ar_est) {
		this.ar_est = ar_est;
	}
	public float getAr_per() {
		return ar_per;
	}
	public void setAr_per(float ar_per) {
		this.ar_per = ar_per;
	}
	public String getAr_incl() {
		return ar_incl;
	}
	public void setAr_incl(String ar_incl) {
		this.ar_incl = ar_incl;
	}
	public String getAr_ori() {
		return ar_ori;
	}
	public void setAr_ori(String ar_ori) {
		this.ar_ori = ar_ori;
	}
	public String getCo_dF() {
		return co_dF;
	}
	public void setCo_dF(String co_dF) {
		this.co_dF = co_dF;
	}
	public String getCo_cF() {
		return co_cF;
	}
	public void setCo_cF(String co_cF) {
		this.co_cF = co_cF;
	}
	public String getCo_Est() {
		return co_Est;
	}
	public void setCo_Est(String co_Est) {
		this.co_Est = co_Est;
	}
	public String getTr_cB() {
		return tr_cB;
	}
	public void setTr_cB(String tr_cB) {
		this.tr_cB = tr_cB;
	}
	public String getTr_cM() {
		return tr_cM;
	}
	public void setTr_cM(String tr_cM) {
		this.tr_cM = tr_cM;
	}
	public String getTr_cA() {
		return tr_cA;
	}
	public void setTr_cA(String tr_cA) {
		this.tr_cA = tr_cA;
	}
	public String getTr_dest() {
		return tr_dest;
	}
	public void setTr_dest(String tr_dest) {
		this.tr_dest = tr_dest;
	}
	public String getTr_interf() {
		return tr_interf;
	}
	public void setTr_interf(String tr_interf) {
		this.tr_interf = tr_interf;
	}
	public String getRa_dest() {
		return ra_dest;
	}
	public void setRa_dest(String ra_dest) {
		this.ra_dest = ra_dest;
	}
	public String getRa_interf() {
		return ra_interf;
	}
	public void setRa_interf(String ra_interf) {
		this.ra_interf = ra_interf;
	}
	public String getAr_s() {
		return ar_s;
	}
	public void setAr_s(String ar_s) {
		this.ar_s = ar_s;
	}
	public String getTr_co() {
		return tr_co;
	}
	public void setTr_co(String tr_co) {
		this.tr_co = tr_co;
	}
	public String getTr_ab() {
		return tr_ab;
	}
	public void setTr_ab(String tr_ab) {
		this.tr_ab = tr_ab;
	}
	public String getTr_desg() {
		return tr_desg;
	}
	public void setTr_desg(String tr_desg) {
		this.tr_desg = tr_desg;
	}
	public String getTr_desc() {
		return tr_desc;
	}
	public void setTr_desc(String tr_desc) {
		this.tr_desc = tr_desc;
	}
	public String getTr_raj() {
		return tr_raj;
	}
	public void setTr_raj(String tr_raj) {
		this.tr_raj = tr_raj;
	}
	public String getTr_fr() {
		return tr_fr;
	}
	public void setTr_fr(String tr_fr) {
		this.tr_fr = tr_fr;
	}
	public String getTr_ch() {
		return tr_ch;
	}
	public void setTr_ch(String tr_ch) {
		this.tr_ch = tr_ch;
	}
	public String getTr_en() {
		return tr_en;
	}
	public void setTr_en(String tr_en) {
		this.tr_en = tr_en;
	}
	public String getRa_co() {
		return ra_co;
	}
	public void setRa_co(String ra_co) {
		this.ra_co = ra_co;
	}
	public String getRa_cr() {
		return ra_cr;
	}
	public void setRa_cr(String ra_cr) {
		this.ra_cr = ra_cr;
	}
	public String getRa_mI() {
		return ra_mI;
	}
	public void setRa_mI(String ra_mI) {
		this.ra_mI = ra_mI;
	}
	public String getRa_s() {
		return ra_s;
	}
	public void setRa_s(String ra_s) {
		this.ra_s = ra_s;
	}
	public String getRa_mR() {
		return ra_mR;
	}
	public void setRa_mR(String ra_mR) {
		this.ra_mR = ra_mR;
	}
	public String getRa_f() {
		return ra_f;
	}
	public void setRa_f(String ra_f) {
		this.ra_f = ra_f;
	}
	public String getRa_c() {
		return ra_c;
	}
	public void setRa_c(String ra_c) {
		this.ra_c = ra_c;
	}
	public String getRa_ex() {
		return ra_ex;
	}
	public void setRa_ex(String ra_ex) {
		this.ra_ex = ra_ex;
	}
	public String getRa_b() {
		return ra_b;
	}
	public void setRa_b(String ra_b) {
		this.ra_b = ra_b;
	}
	public String getRa_ep() {
		return ra_ep;
	}
	public void setRa_ep(String ra_ep) {
		this.ra_ep = ra_ep;
	}
	public String getRa_fr() {
		return ra_fr;
	}
	public void setRa_fr(String ra_fr) {
		this.ra_fr = ra_fr;
	}
	public String getRa_t() {
		return ra_t;
	}
	public void setRa_t(String ra_t) {
		this.ra_t = ra_t;
	}

	
}
