/**
 * Created by SachinChauhan on 14-Sep-17.
 */
public class Trie {

    Trie nodes[];
    int occurrence;
    boolean isEndofWord;

    public Trie(){
        this.nodes=new Trie[94];
        this.occurrence=0;
        for(int i=0;i<94;i++)
            this.nodes[i]=null;
        this.isEndofWord=false;
    }

    void insert(String key){
        Trie temp=this;
        int length=key.length();
        for(int i=0;i<length;i++){
           char c=key.charAt(i);
           int index=(int)c-33;
           if(temp.nodes[index]==null)
                 temp.nodes[index]=new Trie();
           temp=temp.nodes[index];
        }
           temp.isEndofWord=true;
           temp.occurrence++;
    }
    int search(String key){
           Trie temp=this;
           int length=key.length();
           for(int i=0;i<length;i++) {
               char c = key.charAt(i);
               int index=(int)c-33;
               if (temp.nodes[index] == null)
                   return 0;
               temp = temp.nodes[index];
           }
           if(temp.isEndofWord)
           return temp.occurrence;
           return 0;
    }
		/*boolean wordbreak(String key){
			int length=key.length();
			if(length==0){
				System.out.println();
				return true;
			}
			for(int i=1;i<=length;i++){
				if(this.search(key.substring(0,i)) && this.wordbreak(key.substring(i,length))){
					return true;
				}
			}
			return false;
		}*/
}
