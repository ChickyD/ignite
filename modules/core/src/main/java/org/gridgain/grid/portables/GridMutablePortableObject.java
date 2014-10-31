/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.portables;

import org.jetbrains.annotations.*;

/**
 * A wrapper for {@code GridPortableObject} that allow to create copy of the portable object with some modifications.
 *
 * <p>
 * Usage:
 * <pre name=code class=java>
 * GridMutablePortableObject mutableObj = portableObj.toMutable();
 *
 * String firstName = mutableObj.fieldValue("firstName");
 * String lastName = mutableObj.fieldValue("firstName");
 * mutableObj.fieldValue("fullName", firstName + " " + lastName)
 *
 * portableObj = mutableObj.toPortableObject();
 * </pre>
 *
 * <p>
 * This class is not thread-safe.
 */
public interface GridMutablePortableObject extends GridPortableWriter {
    /**
     * Returns the value of the specified field.
     * If the value is another portable object instance of {@code GridMutablePortableObject} will be returned.
     * Arrays and collections returned from this method are modifiable.
     *
     * @param fldName Field name.
     * @return Value of the field.
     */
    public <F> F fieldValue(String fldName);

    /**
     * Sets field value.
     *
     * @param fldName Field name.
     * @param val Field value.
     */
    public void fieldValue(String fldName, @Nullable Object val);

    /**
     * @param hashCode Hash code to set.
     * @return this.
     */
    public GridMutablePortableObject setHashCode(int hashCode);

    /**
     * Returns hashcode of portable object.
     *
     * @return Hashcode.
     */
    public int getHashCode();

    /**
     * Returns new portable object with content from this {@code GridMutablePortableObject}.
     *
     * @return New portable object.
     */
    public GridPortableObject toPortableObject();
}
