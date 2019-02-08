package de.hhu.bsinfo.dxutils.serialization;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class OutputStreamExporter implements Exporter {
    private DataOutputStream m_stream;

    /**
     * Constructor
     *
     * @param p_stream
     *         Output stream to write to
     */
    public OutputStreamExporter(final OutputStream p_stream) {
        m_stream = new DataOutputStream(p_stream);
    }

    @Override
    public void exportObject(final Exportable p_object) {
        p_object.exportObject(this);
    }

    @Override
    public void writeBoolean(boolean p_v) {
        try {
            m_stream.writeBoolean(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeByte(final byte p_v) {
        try {
            m_stream.writeByte(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeShort(final short p_v) {
        try {
            m_stream.writeShort(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeChar(final char p_v) {
        try {
            m_stream.writeChar(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeInt(final int p_v) {
        try {
            m_stream.writeInt(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeLong(final long p_v) {
        try {
            m_stream.writeLong(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeFloat(final float p_v) {
        try {
            m_stream.writeFloat(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeDouble(final double p_v) {
        try {
            m_stream.writeDouble(p_v);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeCompactNumber(int p_v) {
        byte[] number = CompactNumber.compact(p_v);
        writeBytes(number);
    }

    @Override
    public void writeString(final String p_str) {
        writeByteArray(p_str.getBytes(StandardCharsets.US_ASCII));
    }

    @Override
    public int writeBytes(final byte[] p_array) {
        return writeBytes(p_array, 0, p_array.length);
    }

    @Override
    public int writeBytes(final byte[] p_array, final int p_offset, final int p_length) {
        try {
            m_stream.write(p_array, p_offset, p_length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return p_length;
    }

    @Override
    public int writeShorts(final short[] p_array) {
        return writeShorts(p_array, 0, p_array.length);
    }

    @Override
    public int writeChars(final char[] p_array) {
        return writeChars(p_array, 0, p_array.length);
    }

    @Override
    public int writeInts(final int[] p_array) {
        return writeInts(p_array, 0, p_array.length);
    }

    @Override
    public int writeLongs(final long[] p_array) {
        return writeLongs(p_array, 0, p_array.length);
    }

    @Override
    public int writeFloats(final float[] p_array) {
        return writeFloats(p_array, 0, p_array.length);
    }

    @Override
    public int writeDoubles(final double[] p_array) {
        return writeDoubles(p_array, 0, p_array.length);
    }

    @Override
    public int writeShorts(final short[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeShort(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public int writeChars(final char[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeChar(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public int writeInts(final int[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeInt(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public int writeLongs(final long[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeLong(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public int writeFloats(final float[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeFloat(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public int writeDoubles(final double[] p_array, final int p_offset, final int p_length) {
        for (int i = 0; i < p_length; i++) {
            writeDouble(p_array[p_offset + i]);
        }

        return p_length;
    }

    @Override
    public void writeByteArray(final byte[] p_array) {
        writeCompactNumber(p_array.length);
        writeBytes(p_array);
    }

    @Override
    public void writeShortArray(final short[] p_array) {
        writeCompactNumber(p_array.length);
        writeShorts(p_array);
    }

    @Override
    public void writeCharArray(final char[] p_array) {
        writeCompactNumber(p_array.length);
        writeChars(p_array);
    }

    @Override
    public void writeIntArray(final int[] p_array) {
        writeCompactNumber(p_array.length);
        writeInts(p_array);
    }

    @Override
    public void writeLongArray(final long[] p_array) {
        writeCompactNumber(p_array.length);
        writeLongs(p_array);
    }

    @Override
    public void writeFloatArray(final float[] p_array) {
        writeCompactNumber(p_array.length);
        writeFloats(p_array);
    }

    @Override
    public void writeDoubleArray(final double[] p_array) {
        writeCompactNumber(p_array.length);
        writeDoubles(p_array);
    }


}
