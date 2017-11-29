/*
 * Copyright (C) 2017 Heinrich-Heine-Universitaet Duesseldorf, Institute of Computer Science, Department Operating Systems
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package de.hhu.bsinfo.dxutils.reflect.dt;

/**
 * Implementation of a bool parser.
 *
 * @author Stefan Nothaas, stefan.nothaas@hhu.de, 26.01.2016
 */
public class DataTypeParserBool implements DataTypeParser {
    @Override
    public java.lang.String getTypeIdentifer() {
        return "bool";
    }

    @Override
    public Class<?> getClassToConvertTo() {
        return Boolean.class;
    }

    @Override
    public Object parse(final java.lang.String p_str) {
        try {
            // allow 0 and 1 as well
            if ("0".equals(p_str)) {
                return Boolean.FALSE;
            } else if ("1".equals(p_str)) {
                return Boolean.TRUE;
            } else {
                return java.lang.Boolean.parseBoolean(p_str);
            }
        } catch (final NumberFormatException ignored) {
            return Boolean.FALSE;
        }
    }
}
