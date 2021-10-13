public class day101 {
    public boolean isInterLeave(String a,String b,String c){
        if(c.length()==0) return true;
        
        else if((a.length()>0 && a.charAt(0)==c.charAt(0)) && (b.length()>0 && b.charAt(0)==c.charAt(0)) ) return isInterLeave(a.substring(1),b,c.substring(1))||isInterLeave(a,b.substring(1),c.substring(1));
        else if(a.length()>0 && a.charAt(0)==c.charAt(0)) return isInterLeave(a.substring(1),b,c.substring(1));
        else if(b.length()>0 && b.charAt(0)==c.charAt(0)) return isInterLeave(a,b.substring(1),c.substring(1));
        else return false;
	}
}
