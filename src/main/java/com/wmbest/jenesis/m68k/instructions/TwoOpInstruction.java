package com.wmbest.jenesis.m68k.instructions;

import com.wmbest.jenesis.m68k.*;
import com.wmbest.jenesis.util.*;

public abstract class TwoOpInstruction extends SEAInstruction {
    
    @Override
    public void setup(int value) {
        super.setup(value);

        int secondRegister = (value >> (OP_SHIFT + MODE_SHIFT)) & 0x7;
        int secondMode = (value >> OP_SHIFT) & 0x7;

        Operand op = new Operand();
        op.mode = secondMode;
        op.reg = secondRegister;
        op.cpu = cpu;
        operands[1] = op;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString()+ "\n");
        builder.append("Second Type: 0b" + Integer.toBinaryString(operands[1].mode)+ "\n");
        builder.append("Second Register: 0b" + Integer.toBinaryString(operands[1].reg)+ "\n");
        builder.append("Size: " + SIZE_STRING[size] + "\n");
        return builder.toString();
    }

    public String disassemble() {
        return name + "\t" + operands[0].toString() + ", " + operands[1].toString();
    }
}
