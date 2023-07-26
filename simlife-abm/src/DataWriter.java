import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataWriter {
  private String fileName;
  private File outputFile;
  private int interval; // how many iterations between output logging
  private ArrayList<DataField> fields = new ArrayList<>();
  private int time; // interval timer for output logging
  public BufferedWriter writer;

  public void addField(DataField field) {
    fields.add(field);
  }

  public void tick() {
    time += 1;
    if (time % interval == 0) this.logData();
  }

  private void logData() {
    String res = fields.stream()
            .map(item -> item.pullData().toString())
            .reduce("", (out, item) -> out + item);
    System.out.println(res);
  }

  public DataWriter(String fileName, int interval, DataField... fields) {
    this.fileName = fileName;
    this.interval = interval;
    this.fields.addAll(Arrays.asList(fields));
    this.time = 0;
    this.outputFile = new File(fileName);

    try {
      this.writer = new BufferedWriter(new FileWriter(fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws IOException {
    TestTarget<Integer> target1 = new TestTarget<Integer>(1);
    DataField<TestTarget, Integer> field1 = new DataField<>(target1, "getTest", "testField");

    DataWriter data = new DataWriter("output.txt", 1); // represents no. of iterations between output logging
    data.addField(field1);

    for (int i = 0; i <= 100; i++) {
      data.tick();
      target1.setTest(target1.getTest() + 1);
    }

    data.writer.close();

  }
}
