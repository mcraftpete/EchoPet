/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.api.entity.pet.type;


import com.dsh105.echopet.api.entity.AttributeHandler;
import com.dsh105.echopet.api.entity.PetData;
import com.dsh105.echopet.api.entity.PetInfo;
import com.dsh105.echopet.api.entity.PetType;
import com.dsh105.echopet.api.entity.nms.type.EntityOcelotPet;
import com.dsh105.echopet.api.entity.pet.AgeablePetImpl;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;

@PetInfo(type = PetType.OCELOT, width = 0.6F, height = 0.8F)
public class OcelotPetImpl extends AgeablePetImpl implements OcelotPet {

    boolean baby;
    Ocelot.Type type = Ocelot.Type.WILD_OCELOT;

    public OcelotPetImpl(Player owner) {
        super(owner);
    }

    @AttributeHandler(dataType = PetData.Type.CAT_TYPE)
    @Override
    public Ocelot.Type getCatType() {
        return type;
    }

    @AttributeHandler(dataType = PetData.Type.CAT_TYPE, getter = true)
    @Override
    public void setCatType(Ocelot.Type t) {
        setCatType(t.getId());
        this.type = t;
    }

    @Override
    public void setCatType(int i) {
        ((EntityOcelotPet) getEntityPet()).setCatType(i);
        this.type = Ocelot.Type.getType(i);
    }
}