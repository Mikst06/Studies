package wzorce;

public class Triple<L,S,R> {
    private L l;
    private R r;
    private S s;
    public Triple(L l,S s, R r){
        this.l = l;
        this.r = r;
        this.s = s;
    }
    public L getL(){ return l; }
    public R getR(){ return r; }
    public S getS(){ return s; }
    public void setS(S s){ this.s = s; }
    public void setL(L l){ this.l = l; }
    public void setR(R r){ this.r = r; }
}