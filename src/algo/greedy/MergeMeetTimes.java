package algo.greedy;

import java.util.*;

/**
 * @author hasankagalwala on 4/29/20
 * @project algorithms
 *
 * A greedy algorithm builds up a solution by choosing the option that looks the best at every step.
 *
 * Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.
 *
 * For example, given:
 *
 *   [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
 *
 * your method would return:
 *
 *   [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 *
 * <b>Note</b>: Do not assume the meetings are in order. The meeting times are coming from multiple teams.
 *
 *  Be sure to consider these edge cases:
 *
 * The end time of the first meeting and the start time of the second meeting are equal. For example: [Meeting(1, 2), Meeting(2, 3)]
 * The second meeting ends before the first meeting ends. For example: [Meeting(1, 5), Meeting(2, 3)]
 *
 * Algorithm:
 *
 * First, we sort our input list of meetings by start time so any meetings that might need to be merged are now next to each other.
 * Then we walk through our sorted meetings from left to right. At each step, either:
 * We can merge the current meeting with the previous one, so we do.
 * We can't merge the current meeting with the previous one, so we know the previous meeting can't be merged with any future meetings and
 * we throw the current meeting into mergedMeetings.
 *
 * We treat the meeting with earlier start time as "first," and the other as "second."
 * If the end time of the first meeting is equal to or greater than the start time of the second meeting, we merge the two meetings into one time range.
 * The resulting time range's start time is the first meeting's start, and its end time is the later of the two meetings' end times.
 * Else, we leave them separate.
 *
 */
public class MergeMeetTimes {

    public static void main(String[] args) {
        List<Meeting> meetingList = Arrays.asList(new Meeting(1, 10), new Meeting(3, 5), new Meeting(2, 6), new Meeting(7, 9));
        System.out.println(mergeRanges(meetingList));
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // make a copy so we don't destroy the input
        List<Meeting> sortedMeetings = new ArrayList<>(meetings);

        // sort by start time
        Collections.sort(sortedMeetings, Comparator.comparingInt(Meeting::getStartTime));

        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current meeting overlaps with the last merged meeting, use the later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

                // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }

    /**
     * A meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
     * These integers represent the number of 30-minute blocks past 9:00am.
     * For example:
     * new Meeting(2, 3);  // meeting from 10:00 – 10:30 am
     * new Meeting(6, 9);  // meeting from 12:00 – 1:30 pm
     */
    private static class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

}
