public static void playRockPaperScissors(int rounds) {
        String[] options = {"Rock", "Paper", "Scissors"};
        Random rand = new Random();
        
        int wins = 0, losses = 0, draws = 0;
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"}; // Simulated player moves

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < rounds; i++) {
            String playerMove = playerMoves[i % playerMoves.length];
            String computerMove = options[rand.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            
            System.out.printf("  %d   | %-11s | %-13s | %s\n", (i + 1), playerMove, computerMove, result);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.println("--------------------------------------------------");
        System.out.printf("Final Summary (after %d rounds) Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          rounds, wins, losses, draws, winPercentage);
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }