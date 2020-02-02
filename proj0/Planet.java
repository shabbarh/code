public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos=xP;
        yyPos=yP;
        xxVel=xV;
        yyVel=yV;
        mass=m;
        imgFileName=img;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dis;
        double xdif=this.xxPos-p.xxPos;
        double ydif=this.yyPos-p.yyPos;
        dis=Math.sqrt((xdif)*(xdif)+(ydif)*(ydif));
        return dis;
    }
    public double calcForceExertedBy(Planet p){
        double G=6.67/(100000000000.0);
        double r=this.calcDistance(p);
        double force=(G*this.mass*p.mass)/(r*r);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double F=this.calcForceExertedBy(p);
        double dx=p.xxPos-this.xxPos;
        double r=this.calcDistance(p);
        return (F*dx)/r;
    }
    public double calcForceExertedByY(Planet p){
        double F=this.calcForceExertedBy(p);
        double dy=p.yyPos-this.yyPos;
        double r=this.calcDistance(p);
        return (F*dy)/r;
    }
    public double calcNetForceExertedByX(Planet[] arr){
        double Fnetx=0;
        for(Planet p:arr){
            if(this.equals(p))
                continue;
            Fnetx=Fnetx+this.calcForceExertedByX(p);
        }
        return Fnetx;
    }
    public double calcNetForceExertedByY(Planet[] arr){
        double Fnety=0;
        for(Planet p:arr){
            if(this.equals(p))
                continue;
            Fnety=Fnety+this.calcForceExertedByY(p);
        }
        return Fnety;
    }
    public void update(double time,double Fx,double Fy){
        double ax=Fx/this.mass;
        double ay=Fy/this.mass;
        this.xxVel=this.xxVel+time*ax;
        this.yyVel=this.yyVel+time*ay;
        this.xxPos=this.xxPos+time*xxVel;
        this.yyPos=this.yyPos+time*yyVel;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+imgFileName);
    }
}