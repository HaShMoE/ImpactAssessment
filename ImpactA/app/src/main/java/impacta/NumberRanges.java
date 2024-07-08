package impacta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NumberRanges implements NumberRangeSummarizer{
    public String input;

    public NumberRanges() {
        
    }

    //collect the input
    public Collection<Integer> collect(String input) {
        List<Integer> ints = new ArrayList<Integer>();

        // Remove whitespaces and split by commas
        for(String s : input.replaceAll("\\s+","").split(",")) {
            ints.add(Integer.parseInt(s));
        }

        // Sort into ascending order
        Collections.sort(ints);
        return ints;
    }

    //get the summarized string
    public String summarizeCollection(Collection<Integer> input) {
        Iterator<Integer> iterator = input.iterator();

        String summary = "";
        int prev       = iterator.next();
        boolean seq    = false;

        while(iterator.hasNext()){
            int curr = iterator.next();

            if(seq && curr == prev + 1){
                // Numbers continue in sequence
                seq = true;
            } else if(curr == prev + 1){
                // Begin a number sequence
                summary = summary + prev + "-";
                seq = true;
            } else {
                // Numbers not in sequence
                summary = summary + prev + ", ";
                seq = false;
            }

            prev = curr;
        }

        // Add final number to summary
        summary = summary + prev;

        return summary;
    }
}