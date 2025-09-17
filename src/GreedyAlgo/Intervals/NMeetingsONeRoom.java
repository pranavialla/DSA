package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;//maximum number of non overlapping intervals
public class NMeetingsONeRoom {
    static void maxMeetings(int start[], int end[], int n) {

        //better to take meetings which ended first. next comparing the starttime of next meetings which are sorted in the endtime based.
        //if stattime is less than last taken meeting endtime better not to consider current one as it increases
        // end time of all taken meetings and number of meetings remain same
        ArrayList<meeting> meet = new ArrayList<>();

        for (int i = 0; i < start.length; i++)
            meet.add(new meeting(start[i], end[i], i + 1));

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}

class meeting {
    int start;
    int end;
    int pos;

    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}


class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2)
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}

