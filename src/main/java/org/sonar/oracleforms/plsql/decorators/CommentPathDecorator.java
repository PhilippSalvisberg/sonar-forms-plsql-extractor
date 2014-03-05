/*
 * Forms PL/SQL Extractor
 * Copyright (C) 2014 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.oracleforms.plsql.decorators;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.sonar.oracleforms.plsql.Node;

public class CommentPathDecorator implements Decorator {

  public String decorate(Node node, String text) {
    if (node.isGuiItem() && StringUtils.isNotBlank(text)) {
      return new StringBuilder()
          .append("-- path: ")
          .append(node.getKey())
          .append(" (")
          .append(node.getType())
          .append(")")
          .append(IOUtils.LINE_SEPARATOR)
          .append(text)
          .toString();
    }
    return text;
  }

}
