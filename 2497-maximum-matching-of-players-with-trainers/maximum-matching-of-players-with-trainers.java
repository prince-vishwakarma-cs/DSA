class Solution 
{
    public int matchPlayersAndTrainers(int[] players, int[] trainers) 
    {
        // Step 1: Sort the players by their required strength
        Arrays.sort(players);

        // Step 2: Sort the trainers by their capacity
        Arrays.sort(trainers);

        // Step 3: Initialize pointers and match counter
        int i = 0;
        int j = 0;
        int count = 0;

        // Step 4: Use two-pointer technique to match players and trainers
        while (i < players.length && j < trainers.length) 
        {
            if (players[i] <= trainers[j]) 
            {
                // Found a trainer who can train this player
                count++;
                i++;
                j++;
            } 
            else 
            {
                // Current trainer too weak, try next stronger one
                j++;
            }
        }

        // Step 5: Return the total number of successful matches
        return count;
    }
}