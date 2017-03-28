package MapReduce.Grep;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Created by satheesh on 27/3/17.
 */
public class GrepReducer extends Reducer<Text, Text, Text, Text> {

}
