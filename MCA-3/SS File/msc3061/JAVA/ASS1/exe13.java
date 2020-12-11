class exe13{
	public static void main(String args[]){
		double p=1000,r=0.5,n=2;
		double ans;
		double amt,CI;
		ans=(p*r*n)/100;
		System.out.println("The Simple Interest Is"+ans);
		amt=p*(Math.pow((1+(r/100)),n));
		CI=amt-p;
		System.out.println("The Compund Interest Is"+CI);
	}

}