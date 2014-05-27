/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.summer.dsl.xbase.scoping.batch;

import java.util.EnumSet;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket collects a number of types that originate in the
 * very same source, e.g. all imported types are contained in the
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
public class TypeBucket {
  private final int id;
  
  public int getId() {
    return this.id;
  }
  
  private final List<? extends JvmType> types;
  
  public List<? extends JvmType> getTypes() {
    return this.types;
  }
  
  private final IResolvedFeatures.Provider resolvedFeaturesProvider;
  
  public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
    return this.resolvedFeaturesProvider;
  }
  
  public EnumSet<ConformanceHint> getHints() {
    EnumSet<ConformanceHint> _of = EnumSet.<ConformanceHint>of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
    return _of;
  }
  
  public TypeBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super();
    this.id = id;
    this.types = types;
    this.resolvedFeaturesProvider = resolvedFeaturesProvider;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((types== null) ? 0 : types.hashCode());
    result = prime * result + ((resolvedFeaturesProvider== null) ? 0 : resolvedFeaturesProvider.hashCode());
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
    TypeBucket other = (TypeBucket) obj;
    if (other.id != id)
      return false;
    if (types == null) {
      if (other.types != null)
        return false;
    } else if (!types.equals(other.types))
      return false;
    if (resolvedFeaturesProvider == null) {
      if (other.resolvedFeaturesProvider != null)
        return false;
    } else if (!resolvedFeaturesProvider.equals(other.resolvedFeaturesProvider))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
