/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.dsl.xbase.scoping.batch;

import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.summer.dsl.model.types.JvmTypeReference;

/**
 * A type bucket collects a number of types that originate in the
 * very same source, e.g. all implicit receiver types are contained
 * in the very same bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
public class TypeReferenceBucket {
  private final int id;
  
  public int getId() {
    return this.id;
  }
  
  private final List<JvmTypeReference> types;
  
  public List<JvmTypeReference> getTypes() {
    return this.types;
  }
  
  public TypeReferenceBucket(final int id, final List<JvmTypeReference> types) {
    super();
    this.id = id;
    this.types = types;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((types== null) ? 0 : types.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TypeReferenceBucket other = (TypeReferenceBucket) obj;
    if (other.id != id)
      return false;
    if (types == null) {
      if (other.types != null)
        return false;
    } else if (!types.equals(other.types))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
