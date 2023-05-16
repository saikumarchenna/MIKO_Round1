import java.util.HashMap;
import java.util.Map;

public class AssemblyInterpreter {
    private static final String PATTERN_MV = "MV (\\w+),#(\\d+)";
    private static final String PATTERN_ADD_REG = "ADD (\\w+), (\\w+)";
    private static final String PATTERN_ADD_CONST = "ADD (\\w+),(\\d+)";
    private static final String PATTERN_SHOW = "SHOW (\\w+)";
    
    private static final Map<String, Integer> registers = new HashMap<>();
    
    public static void main(String[] args) {
        String assemblyCode = "MV REG1,#2000\nMV REG2,#4000\nADD REG1, REG2\nADD REG1,600\nSHOW REG";
        String[] instructions = assemblyCode.split("\n");
        
        for (String instruction : instructions) {
            executeInstruction(instruction);
        }
    }
    
    private static void executeInstruction(String instruction) {
        if (instruction.matches(PATTERN_MV)) {
            String[] parts = instruction.split(" ");
            String register = parts[1];
            int value = Integer.parseInt(parts[2].substring(1));
            registers.put(register, value);
        } else if (instruction.matches(PATTERN_ADD_REG)) {
            String[] parts = instruction.split(" ");
            String register1 = parts[1];
            String register2 = parts[2];
            int value1 = registers.get(register1);
            int value2 = registers.get(register2);
            registers.put(register1, value1 + value2);
        } else if (instruction.matches(PATTERN_ADD_CONST)) {
            String[] parts = instruction.split(" ");
            String register = parts[1];
            int value1 = registers.get(register);
            int value2 = Integer.parseInt(parts[2]);
            registers.put(register, value1 + value2);
        } else if (instruction.matches(PATTERN_SHOW)) {
            String[] parts = instruction.split(" ");
            String register = parts[1];
            int value = registers.get(register);
            System.out.println(register + ": " + value);
        } else {
            System.out.println("Invalid instruction: " + instruction);
        }
    }
}
