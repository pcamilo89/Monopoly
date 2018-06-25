/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Core;
import static model.Core.initCore;

/**
 *
 * @author ryu_a
 */
public class TestCommunityAndChanceList
{
    public static void main(String[] args)
    {
        initCore();
        model.Core.fillChanceCardList(Core.chanceList);
        model.Core.fillCommunityCardList(Core.communityList);
    }
}
