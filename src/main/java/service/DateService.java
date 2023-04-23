package service;

import utils.TimeAgo;
import java.util.Date;

public class DateService {

    public String getDisplayDate(Date date){
        return TimeAgo.toDuration(date.getTime());
    }

}
