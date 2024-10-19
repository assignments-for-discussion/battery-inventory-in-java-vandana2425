package bunchbysoh;

public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();
        int ratedCapacity = 120; // Rated capacity of a new battery

        for (int i = 0; i < presentCapacities.length; i++) {
            int presentCapacity = presentCapacities[i];
            double soh = (100.0 * presentCapacity) / ratedCapacity; 

            if (soh > 80) {
                counts.healthy++;
            } else if (soh >= 62) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }

        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");
        int[] presentCapacities = {113, 116, 80, 95, 92, 70};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);

        assert(counts.healthy == 2);
        assert(counts.exchange == 3);
        assert(counts.failed == 1);
        
        //Running more tests
        assert(countBatteriesByHealth(new int[]{120}).healthy == 1);
        assert(countBatteriesByHealth(new int[]{100}).healthy == 1); 
        assert(countBatteriesByHealth(new int[]{80}).exchange == 1); 
        assert(countBatteriesByHealth(new int[]{75}).failed == 1); 
        assert(countBatteriesByHealth(new int[]{60}).failed == 1);
        assert(countBatteriesByHealth(new int[]{42}).failed == 1);
        
        //printing addtional test values and comparing with expected
        System.out.println("Test 1: Present Capacity [120]");
        counts = countBatteriesByHealth(new int[]{120});
        System.out.println("Expected Healthy: 1, Actual Healthy: " + counts.healthy + "\n");

        System.out.println("Test 2: Present Capacity [100]");
        counts = countBatteriesByHealth(new int[]{100});
        System.out.println("Expected Healthy: 1, Actual Healthy: " + counts.healthy + "\n");

        System.out.println("Test 3: Present Capacity [80]");
        counts = countBatteriesByHealth(new int[]{80});
        System.out.println("Expected Exchange: 1, Actual Exchange: " + counts.exchange + "\n");

        System.out.println("Test 4: Present Capacity [75]");
        counts = countBatteriesByHealth(new int[]{75});
        System.out.println("Expected Failed: 1, Actual Failed: " + counts.failed + "\n");

        System.out.println("Test 5: Present Capacity [60]");
        counts = countBatteriesByHealth(new int[]{60});
        System.out.println("Expected Failed: 1, Actual Failed: " + counts.failed + "\n");

        System.out.println("Test 6: Present Capacity [42]");
        counts = countBatteriesByHealth(new int[]{42});
        System.out.println("Expected Failed: 1, Actual Failed: " + counts.failed + "\n");
        
        
        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
