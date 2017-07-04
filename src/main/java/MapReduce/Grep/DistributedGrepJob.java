package MapReduce.Grep;


import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.NullWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


import java.io.IOException;


/**
 * Created by satheesh on 27/3/17.
 */

public class DistributedGrepJob {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
     
   Configuration conf = new Configuration();
  
      conf.set("mapregex", "T[0]*");

  
      Job job = new Job(conf, "Distributed Grep");
  
      job.setJarByClass(DistributedGrepJob.class);
   
     job.setMapperClass(GrepMapper.class);
     
   job.setOutputKeyClass(NullWritable.class);
    
    job.setOutputValueClass(Text.class);

        job.setNumReduceTasks(0); // Set number of reducers to zero
  
      FileInputFormat.addInputPath(job, new Path("/home/satheesh/projects/Java/hadoopAssignments/src/main/java/MapReduce/InvertedIndex/sample-inverted.txt"));
      FileOutputFormat.setOutputPath(job, new Path("/home/satheesh/projects/Java/hadoopAssignments/src/main/java/MapReduce/Grep/output"));

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    
}
}
