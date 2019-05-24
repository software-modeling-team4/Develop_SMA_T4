import java.util.ArrayList;
import java.util.Calendar;

public class ModeDB {

    private ArrayList<ArrayList> db;
    public ModeDB(){
        this.db = new ArrayList<ArrayList>();
        for(int i = 0; i < 5; i++)
            db.add(null); // 0: Stopwatch, 1: Timer, 2: Alarm, 3: Worldtime, 4: Sun
    }

    public ArrayList loadData(int index){ return this.db.get(index); }
    public void saveData(int index, ArrayList data){

        switch(index){
            case 0: // 0: Stopwatch
                System.out.println("this.stpTime: " + ((Calendar)data.get(0)).getTimeInMillis());
                System.out.println("this.splitTime: " + ((Calendar)data.get(1)).getTimeInMillis());
                break;
            case 1: // 1: Timer
                break;
            case 2: // 2: Alarm
                break;
            case 3: // 3: Worldtime
                break;
            case 4: // 4: sun
                break;
            default:
                break;

        }


        this.db.set(index, data);
    }
}
