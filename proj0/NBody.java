public class NBody {
    public static double readRadius(String str){
        In in = new In(str);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String str){
        In in = new In(str);
        int N=in.readInt();
        in.readDouble();
        Planet P[]=new Planet[N];
        int i=0;
        while(i<N){
            double xp=in.readDouble();
            double  yp=in.readDouble();
            double xv=in.readDouble();
            double yv=in.readDouble();
            double m=in.readDouble();
            String img=in.readString();
            P[i]=new Planet(xp,yp,xv,yv,m,img);
            i++;
        }
        return P;
    }
    public static void  main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double Uradius=readRadius(filename);
        Planet[] P=readPlanets(filename);
        StdDraw.setScale(-Uradius,Uradius);
        StdDraw.picture(0,0,"images/starfield.jpg");
        for(Planet p:P)
            p.draw();
        StdDraw.enableDoubleBuffering();
        double t=0;
        while(t<T){
            double[] xForces=new double[P.length];
            double[] yForces=new double[P.length];
            int n=0;
            while(n<P.length) {
                xForces[n] = P[n].calcNetForceExertedByX(P);
                yForces[n] = P[n].calcNetForceExertedByY(P);
                n++;
            }
            n=0;
            while(n<P.length) {
                P[n].update(dt, xForces[n], yForces[n]);
                n++;
            }
            n=0;
            StdDraw.picture(0,0,"images/starfield.jpg");
            while(n<P.length){
                P[n].draw();
                n++;
            }
            StdDraw.show();
            StdDraw.pause(10);
            t+=dt;
        }
        StdOut.printf("%d\n",P.length);
        StdOut.printf("%.2e\n",Uradius);
        for(int i=0;i<P.length;i++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",P[i].xxPos,P[i].yyPos,P[i].xxVel,P[i].yyVel,P[i].mass,P[i].imgFileName);
        }
    }
}
