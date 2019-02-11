package de.hhu.bsinfo.dxutils.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamImporter implements Importer {

    private DataInputStream m_input;

    public StreamImporter(InputStream p_inputStream) {
        m_input = new DataInputStream(p_inputStream);
    }

    public StreamImporter(DataInputStream p_inputStream) {
        m_input = p_inputStream;
    }

    @Override
    public void importObject(final Importable p_object) {
        p_object.importObject(this);
    }

    @Override
    public boolean readBoolean(final boolean p_bool) {
        try {
            return m_input.readBoolean();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte readByte(final byte p_byte) {
        try {
            return m_input.readByte();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public short readShort(final short p_short) {
        try {
            return m_input.readShort();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public char readChar(final char p_char) {
        try {
            return m_input.readChar();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readInt(final int p_int) {
        try {
            return m_input.readInt();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long readLong(final long p_long) {
        try {
            return m_input.readLong();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public float readFloat(final float p_float) {
        try {
            return m_input.readFloat();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public double readDouble(final double p_double) {
        try {
            return m_input.readDouble();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readCompactNumber(final int p_int) {
        byte[] tmp = new byte[4];
        int i;

        for (i = 0; i < Integer.BYTES; i++) {
            tmp[i] = readByte((byte) 0);
            if ((tmp[i] & 0x80) == 0) {
                break;
            }
        }

        return CompactNumber.decompact(tmp, 0, i);
    }

    @Override
    public String readString(final String p_string) {
        return new String(readByteArray(null));
    }

    @Override
    public int readBytes(final byte[] p_array) {
        try {
            return m_input.read(p_array);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readShorts(final short[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readShort();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readChars(final char[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readChar();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readInts(final int[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readInt();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readLongs(final long[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readLong();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readFloats(final float[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readFloat();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readDoubles(final double[] p_array) {
        try {
            for (int i = 0; i < p_array.length; i++) {
                p_array[i] = m_input.readDouble();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readBytes(final byte[] p_array, final int p_offset, final int p_length) {
        try {
            return m_input.read(p_array, p_offset, p_length);
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readShorts(final short[] p_array, final int p_offset, final int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readShort();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readChars(char[] p_array, int p_offset, int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readChar();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readInts(final int[] p_array, final int p_offset, final int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readInt();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readLongs(final long[] p_array, final int p_offset, final int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readLong();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readFloats(final float[] p_array, final int p_offset, final int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readFloat();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int readDoubles(final double[] p_array, final int p_offset, final int p_length) {
        try {
            for (int i = p_offset; i < p_length; i++) {
                p_array[i] = m_input.readDouble();
            }

            return p_array.length;
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] readByteArray(final byte[] p_array) {
        byte[] arr = new byte[readCompactNumber(0)];
        readBytes(arr);
        return arr;
    }

    @Override
    public short[] readShortArray(final short[] p_array) {
        short[] arr = new short[readCompactNumber(0)];
        readShorts(arr);
        return arr;
    }

    @Override
    public char[] readCharArray(final char[] p_array) {
        char[] arr = new char[readCompactNumber(0)];
        readChars(arr);
        return arr;
    }

    @Override
    public int[] readIntArray(final int[] p_array) {
        int[] arr = new int[readCompactNumber(0)];
        readInts(arr);
        return arr;
    }

    @Override
    public long[] readLongArray(final long[] p_array) {
        long[] arr = new long[readCompactNumber(0)];
        readLongs(arr);
        return arr;
    }

    @Override
    public float[] readFloatArray(final float[] p_array) {
        float[] arr = new float[readCompactNumber(0)];
        readFloats(arr);
        return arr;
    }

    @Override
    public double[] readDoubleArray(final double[] p_array) {
        double[] arr = new double[readCompactNumber(0)];
        readDoubles(arr);
        return arr;
    }
}
