package com.dos.gasa_helper;

/**
 * 임시 유저 데이터
 * Created by Hago on 2016-08-07.
 */
public class FakeUserData {
    public static String[] aryUserName = {"김동훈", "손지훈", "최진우", "김후곤", "김재현", "백서인", "최재원", "민석범", "김병지", "최승현"};
    public static int[] aryUserImageId = {R.drawable.user_character_b01, R.drawable.user_character_b02, R.drawable.user_character_b03,
            R.drawable.user_character_b04, R.drawable.user_character_b05, R.drawable.user_character_b06,
            R.drawable.user_character_b07, R.drawable.user_character_b08, R.drawable.user_character_b09,
            R.drawable.user_character_b10,};
    public static String[] aryLocation = {"둔촌아파트 101동 101호", "둔촌아파트 201동 101호", "둔촌아파트 301동 101호",
            "둔촌아파트 401동 101호", "둔촌아파트 501동 101호", "둔촌아파트 601동 101호",
            "둔촌아파트 701동 101호", "둔촌아파트 801동 101호", "둔촌아파트 901동 101호",
            "둔촌아파트 902동 101호"};
    public static String[] aryPay = {"5000원", "6000원", "7000원", "8000원", "9000원",
            "5000원", "6000원", "7000원", "8000원", "9000원",};

    public static void setListItem(CategoryListViewAdapter adapter) {
        for (int i = 0; i < aryUserName.length; i++) {
            adapter.addItem(aryUserImageId[i], aryUserName[i], "무슨일을 할까?", aryLocation[i], aryPay[i]);
        }
    }
}
