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
import org.summer.dsl.xbase.scoping.batch.TypeBucket;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket that was produced from the synonym of a type.
 * It tracks the conformance hints for a synonym, e.g. boxing or unboxing information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
public class SynonymTypeBucket extends TypeBucket {
  private final EnumSet<ConformanceHint> hints;
  
  public EnumSet<ConformanceHint> getHints() {
    return this.hints;
  }
  
  public SynonymTypeBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider, final EnumSet<ConformanceHint> hints) {
    super(id, types, resolvedFeaturesProvider);
    this.hints = hints;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((hints== null) ? 0 : hints.hashCode());
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
    if (!super.equals(obj))
      return false;
    SynonymTypeBucket other = (SynonymTypeBucket) obj;
    if (hints == null) {
      if (other.hints != null)
        return false;
    } else if (!hints.equals(other.hints))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
