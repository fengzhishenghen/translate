package translate;
import translate.Constants;

public class Utils {
	
	public static String translate(String str){
		String r="";
		String must=mustTranslate(str);
		String tibuTranslate=tibuTranslate(str);
		String RoomType=RoomTypeTranslate(str);
		String attach=attachTranslate(str);
		if(must.equals("")&&RoomType.equals("")){
			r=tibuTranslate+"房"+attach;
		}else if(!RoomType.equals("")){
			r=must+RoomType+attach;
		}else{
			r=must+"房"+attach;
		}
		return r;
	}
	
	
	
	public static String mustTranslate(String str){
		int n=Constants.mustTranslate.length;
		boolean flag=false;
		String r="";
		for(int i=0;i<n;i++){
			int l=Constants.mustTranslate[i].length;
			for(int j=0;j<l-1;j++){
				if(Contains(str,Constants.mustTranslate[i][j])){
					r=r+Constants.mustTranslate[i][l-1];
					flag=true;
					break;
				}
			}
		}
		return r;
	}
	public static String tibuTranslate(String str){		
		int n=Constants.tibu.length;
		String r="";
		for(int i=0;i<n;i++){
			int l=Constants.tibu[i].length;
			for(int j=0;j<l-1;j++){
				if(Contains(str,Constants.tibu[i][j])){
					r=r+Constants.tibu[i][l-1];
					return r;
				}
			}
		}		
		return r;
	}
	public static String RoomTypeTranslate(String str){		
		int n=Constants.roomType.length;
		String r="";
		for(int i=0;i<n;i++){
			int l=Constants.roomType[i].length;
			for(int j=0;j<l-1;j++){
				if(Contains(str,Constants.roomType[i][j])){
					r=r+Constants.roomType[i][l-1];
					return r;
				}
			}
		}		
		return r;
	}
	public static String attachTranslate(String str){		
		int n=Constants.attach.length;
		String r="";
		for(int i=0;i<n;i++){
			int l=Constants.attach[i].length;
			for(int j=0;j<l-1;j++){
				if(Contains(str,Constants.attach[i][j])){
					r=r+Constants.roomType[i][l-1];
					return r;
				}
			}
		}		
		return r;
	}
	public static boolean Contains(String str,String s){
		/*int n1=str.length(),n2=s.length();
		if(n2>n1)return false;
		for(int i=0;i<n1-n2;i++){
			for(int j=0;j<n2;j++){
				if(str.substring(i,i+n2).equalsIgnoreCase(s)){
					return true;
				}
			}
		}
		return false;*/
		String[] Str=str.split("[' ',(,)]");
		String[] S=s.split(" ");
		int n1=Str.length,n2=S.length;
		if(n2>n1)return false;
		for(int i=0;i<=n1-n2;i++){
			int count=0;
			for(int j=0;j<n2;j++){
				if(Str[i+j].equalsIgnoreCase(S[j])){
					count++;
				}
			}
			if(count==n2){
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args){
		String str="Run of the House Single";
		String s="Run of  House";
		String[] Str=str.split("[' ',(,)]");
		//String r=translate(str);
		System.out.println(Contains(str,s));
		for(String t:Str)
			System.out.println(t);
		
	}

}
