/*
 * Copyright (c) 2011, 2012, Tyler Blair
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are
 * permitted provided that the following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and contributors and should not be interpreted as representing official policies,
 * either expressed or implied, of anybody else.
 */

package com.griefcraft.spout.world;

import com.griefcraft.world.Block;
import com.griefcraft.world.World;
import org.spout.api.material.BlockMaterial;
import org.spout.api.material.Material;
import org.spout.vanilla.material.VanillaMaterial;

// TODO implement hashCode / equals
public class SpoutBlock extends Block {

    /**
     * The spout block handle
     */
    private final org.spout.api.geo.cuboid.Block handle;

    /**
     * The world this block is located in
     */
    private World world;

    public SpoutBlock(World world, org.spout.api.geo.cuboid.Block handle) {
        if (handle == null) {
            throw new IllegalArgumentException("Block handle cannot be null");
        }

        this.world = world;
        this.handle = handle;
    }

    public int getType() {
        BlockMaterial material = handle.getMaterial();

        // use Vanilla MC ids if it's a non-Spout block
        if (material instanceof VanillaMaterial) {
            return ((VanillaMaterial) material).getMinecraftId();
        }

        // it is a spout block
        return handle.getMaterial().getId();
    }

    public byte getData() {
        return (byte) handle.getData();
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return handle.getX();
    }

    public int getY() {
        return handle.getY();
    }

    public int getZ() {
        return handle.getZ();
    }

    public void setType(int type) {
        handle.setMaterial(Material.get(type));
    }

    public void setData(byte data) {
        handle.setData(data);
    }

}
