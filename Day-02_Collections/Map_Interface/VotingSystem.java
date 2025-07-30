import java.util.*;

public class VotingSystem {
    // Store candidate -> votes
    private Map<String, Integer> voteCountMap = new HashMap<>();

    // Maintain the order in which votes were cast
    private LinkedHashMap<Integer, String> voteOrderMap = new LinkedHashMap<>();

    private int voteId = 1;

    // Cast a vote for a candidate
    public void castVote(String candidate) {
        voteCountMap.put(candidate, voteCountMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(voteId++, candidate);
    }

    // Display vote counts (unordered)
    public void displayRawVotes() {
        System.out.println("\n🔢 Vote Counts (Unordered):");
        for (Map.Entry<String, Integer> entry : voteCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Display votes in order of casting
    public void displayVoteCastingOrder() {
        System.out.println("\n🕒 Vote Casting Order:");
        for (Map.Entry<Integer, String> entry : voteOrderMap.entrySet()) {
            System.out.println("Vote #" + entry.getKey() + " → " + entry.getValue());
        }
    }

    // Display sorted results (by candidate name)
    public void displaySortedResults() {
        System.out.println("\n📊 Final Sorted Results (Alphabetical):");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteCountMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " vote(s)");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Simulate votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display various outputs
        system.displayRawVotes();
        system.displayVoteCastingOrder();
        system.displaySortedResults();
    }
}
