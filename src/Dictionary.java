import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dictionary {

    private File[] files;
    private Trie root[];
	public Dictionary(File[] infiles,IndexingScreen indexingScreen) throws FileNotFoundException {

	    files=infiles;
		int length=infiles.length;
		root=new Trie[length];
		ExecutorService executorService= Executors.newSingleThreadExecutor();
		executorService.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<length;i++){
                    root[i]=new Trie();
                    try {
                        Scanner sc = new Scanner(infiles[i]);
                        while(sc.hasNextLine()){
                            String input=sc.nextLine();
                            String words[]=input.split(" ");
                            for(int j=0;j<words.length;j++)
                                root[i].insert(words[j]);
                            indexingScreen.indexProgressBar.setValue(i*100/length);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
		indexingScreen.frame.setVisible(false);
		new SecondScreen(this);
	}
	public void search(String word,ProcessingScreen processingScreen){

	    int length=files.length;
	    int occurence[]=new int[length];
	    ExecutorService executorService=Executors.newSingleThreadExecutor();
	    executorService.execute(new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<length;i++)
                    occurence[i]=root[i].search(word);

                for(int i=0;i<length-1;i++) {
                    for (int j = 0; j < length - i-1; j++)
                        if (occurence[j] > occurence[j + 1]) {

                            File temp = files[j];
                            files[j] = files[j + 1];
                            files[j + 1] = temp;

                            int t=occurence[j];
                            occurence[j]=occurence[j+1];
                            occurence[j+1]=t;
                        }
                    processingScreen.progressBar.setValue(i * 100 / length);
                }
            }
        });
        processingScreen.frame.setVisible(false);
        new ResultScreen(files,occurence,this);
	}
}
