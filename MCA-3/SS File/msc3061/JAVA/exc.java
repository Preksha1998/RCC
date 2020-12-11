class multipleCatch{
	public static void main(String args[]){
		try{
			int a=1;
			a=a/(a-a);
			int arr[]={0};
			arr[20]=90;
			
		}
		catch(Exception e){
			System.out.println("Divison By Zero");

		}
		catch(Exception e){
			System.out.println("Array Out Of Bound");
		}
	}

}