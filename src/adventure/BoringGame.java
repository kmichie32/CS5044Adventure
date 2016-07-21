package adventure;

public class BoringGame extends Game
{
    public BoringGame()
    {
    	
    }
    
    public static void main(String[] args) {
    	Game game = new BoringGame();
    	game.play();
    }
    
    public String welcomeMessage()
    {
        return
            "<p>Welcome to The World of Simplicity!</p>"
            + "<p>Type 'help' if you need help.</p>"
            + "<p>Hit [return] to continue...</p>"
; }
    
    public void createRooms()
    {
        // create the rooms
        Room outside = new Room("outside McBryde Hall");
        Room lab     = new Room("in a computing lab");

        // initialise room exits
        outside.setExit("south", lab);
        lab.setExit("north", outside);

        // the player starts the game outside
        player().setCurrentRoom(outside);
    }
    
    public void createCommands()
    {
        CommandWords commands = parser().commandWords();
        commands.addCommand("go",   new GoCommand());
        commands.addCommand("help", new HelpCommand(commands));
        commands.addCommand("quit", new QuitCommand());
    }
    
}
