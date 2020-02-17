package com.merve.machine;

import com.merve.machine.model.DirectionTest;
import com.merve.machine.model.GridTest;
import com.merve.machine.model.MachineTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        DirectionTest.class,
        GridTest.class,
        MachineTest.class
})

@SpringBootTest
public class MachineApplicationTests {


}
