package main.java.leetCodeProblems.algorithm;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Example how an iteration can be adapted to {@link java.util.stream.Stream}
 */
public class ExampleStreamTransformation
{
    public static void main(String[] args)
    {
        dateBucketSize();
    }

    private static void dateBucketSize()
    {
        ZonedDateTime zonedDateTimeFrom = ZonedDateTime.now().minus(5, ChronoUnit.DAYS) ;
        ZonedDateTime zonedDateTimeTo = ZonedDateTime.now().plus(1, ChronoUnit.DAYS);
        ChronoUnit chronoUnit = ChronoUnit.HOURS;
        List<DateBucket> streamVersion = DateBucket.bucketSizeStreamVersion (zonedDateTimeFrom, zonedDateTimeTo, 100, chronoUnit);
        List<DateBucket> iterationVersion = DateBucket.bucketSizeIterationVersion(zonedDateTimeFrom, zonedDateTimeTo, 100, chronoUnit);

        System.out.println("Bucket Size Iteration Version (Original): " + iterationVersion.size()  );
        System.out.println("Bucket Size Stream Version: " + streamVersion.size()  );
    }

    static class DateBucket {
        final Instant from;
        final Instant to;

        DateBucket(Instant from, Instant to)
        {
            this.from = from;
            this.to = to;
        }

        public static List<DateBucket> bucketSizeStreamVersion(
            ZonedDateTime fromDate,
            ZonedDateTime toDate,
            int bucketSize,
            ChronoUnit bucketSizeUnit) {

            // Calculates number of buckets using the bucketSize and dates.
            long numberOfBuckets = bucketSizeUnit.between(fromDate, toDate) / bucketSize + 1;
            // Iterates from Zero to numberOfBuckets, per cycle extract a bucket.
            // Use a LongStream since numberOfBuckets is long.
            return LongStream.range(0, numberOfBuckets)
                .mapToObj( numberBucket -> new DateBucket(
                    fromDate.plus(numberBucket * bucketSize, bucketSizeUnit).toInstant(),
                    fromDate.plus((numberBucket+1) * bucketSize, bucketSizeUnit).toInstant()))
                .collect(Collectors.toList());
        }

        public static List<DateBucket> bucketSizeIterationVersion(
            ZonedDateTime fromDate,
            ZonedDateTime toDate,
            int bucketSize,
            ChronoUnit bucketSizeUnit) {

            boolean reachedDate = false;
            List<DateBucket> buckets = new ArrayList<>();
            for (int i = 0; !reachedDate; i++) {
                ZonedDateTime minDate = fromDate.plus((long)i * bucketSize, bucketSizeUnit);
                ZonedDateTime maxDate = fromDate.plus((long)(i + 1) * bucketSize, bucketSizeUnit);
                reachedDate = toDate.isBefore(maxDate);
                buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
            }

             return buckets;
        }
    }

}
