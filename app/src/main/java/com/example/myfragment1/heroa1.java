package com.example.myfragment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class heroa1 extends AppCompatActivity {
    String[] name={"鋼鐵人","美國隊長","雷神索爾","浩克","黑寡婦","鷹眼","緋紅女巫","快銀","幻視","戰爭機器","獵鷹","蟻人","黑豹","蜘蛛人","奇異博士","酷寒戰士/白狼","驚奇隊長","星爵","葛摩菈","火箭浣熊"
            ,"格魯特","德克斯","涅布拉","螳螂女","黃蜂女","尼克福瑞","奧科耶","瓦爾基麗","王","寇克"};


    String[] actor={"小勞勃·道尼(Robert Downey Jr.)","克里斯·伊凡(Chris Evans)","克里斯·漢斯沃（Chris Hemsworth)","艾德華·諾頓(Edward Norton)[無敵浩克]\n"+"馬克·魯法洛(Mark Ruffalo)[漫威電影系列]"
            ,"史嘉蕾·喬韓森(Scarlett Johansson)"
            ,"傑瑞米·雷納(Jeremy Renner)","伊莉莎白·歐森(Elizabeth Olsen)","亞倫·強森(Aaron Taylor-Johnson)","保羅·巴特尼(Paul Bettany)","泰倫斯·霍華(Terrence Howard)[鋼鐵人]/\n" +
            "唐·奇鐸(Don Cheadle)[其他系列]","安東尼·麥基(Anthony Mackie)","保羅·路德(Paul Rudd)","查德威克·鮑斯曼(Chadwick Boseman)","湯姆·霍蘭德(Tom Holland)","班奈狄克·康柏拜區(Benedict Cumberbatch)"
            ,"賽巴斯汀·斯坦(Sebastian Stan)","布麗·拉森(Brie Larson)","克里斯·普瑞特(Chris Pratt)","柔伊·莎達娜(Zoe Saldana)","布萊德利·庫柏(Bradley Cooper)/配音","馮·迪索(Vin Diesel)/配音","戴夫·巴帝斯塔(Dave Bautista)"
            ,"凱倫·吉蘭(Karen Gillan)","龐·克萊門捷夫(Pom Klementieff)","伊凡潔琳·莉莉(Evangeline Lilly)","山繆·傑克森 (Samuel L. Jackson)","達娜·古瑞拉(Danai Gurira)","泰莎·湯普森 (Tessa Thompson)"
            ,"黃凱旋(Benedict Wong)","塔伊加·維迪提 (Taika Waititi)"};


    String[] introdicion={"本名為東尼·史塔克。\n" +
            "小時候即展現驚人的天賦，僅15歲時就進入麻省理工學院電子工程學系大學部就讀，於19歲時以最高分的成績獲得雙碩士學位。\n" +
            "史塔克繼承了父親擁有的史塔克企業。為史塔克工業的首席執行長和美國軍隊的主要軍火製造商。\n" +
            "因一次到阿富汗時遭十環幫擄走，讓他的心臟受重創，僅靠胸口的微型方舟反應爐續命。逃出後成為了鋼鐵人，其後加入復仇者聯盟。","本名為史蒂芬·羅傑斯\n" +
            "二次大戰期間，看不慣納粹黨在歐洲的暴行而決心參軍成爲英勇的戰士，但因身軀矮小、體弱多病而五次被拒絕。\n" +
            "軍方科學家亞拉伯罕·艾斯金賞識史蒂芬對從軍的熱情，於是輕易讓他通過體檢，並將他列為一個軍方秘密科學計畫的候選人。\n" +
            "艾斯金將他研發的「超級戰士血清」注入史蒂芬的體內後，隨著能量值達到百分之百，史蒂芬從一名柔弱男子轉變成一個高大威猛的超級戰士。","本名索爾，奥丁森\n" +
            "是奧丁與芙麗嘉之子，與奧丁所收養的冰霜巨人之子洛基一同長大成人，獲得了使用雷神之鎚的資格。\n" +
            "他是阿斯嘉的守護者和繼承人。但他後來逐漸變得傲慢自大，所以被父親奧丁打入人間以學習謙遜。\n" +
            "其後發現弟弟洛基的陰謀後回到阿斯嘉阻止他，之後發現洛基企圖在他最愛的地球中引起混亂而因此加入復仇者聯盟。","本名布魯斯·班納\n" +
            "研究伽馬射線的科學家、遺傳學家、核子物理學家等。\n" +
            "羅斯將軍希望重啟二戰時期有關「超級戰士」的實驗—該實驗失敗並出了意外，布魯斯·班納為救同事而被伽瑪射線照射到身體，\n" +
            "繼而產生異變，這導致他每當被激怒時，他的心率每分鐘超過200次，他就會短暫地變成綠色的巨人，並擁有無窮的力量，成為他的分身——浩克。","本名為娜塔莎·羅曼諾夫\n" +
            "神盾局前成員，初期被安排在史塔克工業臥底來監視東尼的一舉一動，後為復仇者聯盟一員。\n" +
            "以前是位冷酷無情的殺手被神盾局派鷹眼來殺她，反被鷹眼邀請進神盾局工作。","本名為克林特·巴頓\n" +
            "神盾局前特工。曾與黑寡婦是多年好友。\n" +
            "受到彈指事件影響鷹眼全家，使鷹眼轉變為私刑者浪人屠殺各地黑道。","本名為汪達·馬克希莫夫\n" +
            "快銀的雙胞胎妹妹，從小與哥哥相依為命。自願加入九頭蛇的人體實驗\n" +
            "為了向長期讓自己家鄉暴於恐懼之下的史塔克家族報仇與奧創同盟，卻看穿奧創毀滅世界的企圖心而叛變，轉向支援復仇者聯盟。","本名為皮特洛·馬克希莫夫\n" +
            "緋紅女巫的雙胞胎哥哥，小時候因為史塔克工業製造的武器而失去了父母，於是為了復仇而自願加入九頭蛇的人體實驗\n" +
            "為了向長期讓自己家鄉暴於恐懼之下的史塔克家族報仇與奧創同盟，卻看穿奧創毀滅世界的企圖心而叛變，轉向支援復仇者聯盟。","東尼設計的人工智慧管家「賈維斯」的更新版本，身體是奧創用「再生搖籃」製造，並由汎合金為材料，\n" +
            "生命來源來自於權杖上的心靈寶石，後來由班納和史塔克上傳賈維斯的意識完成，最後成為寶石的主要保管者。","本名為詹姆士·「羅德」·羅德斯\n" +
            "東尼的拍檔，美國空軍軍事採購聯絡人，當年在麻省理工學院進行航空進修學時認識了東尼，為史塔克工業與美國空軍之間的聯絡橋梁。\n" +
            "是東尼少數幾個值得信賴的朋友，絕大部分時間耐心的對待那個容易衝動的天才。","本名為山姆·威爾森\n" +
            "前美軍退役傘兵，是美國隊長史蒂芬·羅傑斯早上晨練所結識的夥伴。\n" +
            "美國空軍的秘密飛行計畫的唯二飛行員之一：以高科技羽翼飛行進行作戰或探查情報，因山姆的同袍進行一場飛行任務時而不幸墬毀，導致計畫曝光而暫停。","本名為史考特·朗恩\n"+"有著竊盜前科的電機工程師，偷竊技巧十分高超，其特質被漢克·皮姆挑選上成為第二代蟻人。\n" +
            "有一個長期分居但非常疼愛的女兒凱西，和山姆打過一戰後被他看上身手。因幫助美國隊長而與克林特·巴頓被判處居家軟禁。","本名為帝查拉\n" +
            "虛構非洲國家「瓦干達」的國王，在父親死後繼承王位，同時也繼承了黑豹的稱號。","本名為彼得·帕克\n" +
            "住在皇后區的普通高中生，被蜘蛛咬傷後獲得蜘蛛的能力，化身蜘蛛人開始懲奸鬥惡。\n" +
            "被東尼賞識招募加入復仇者聯盟的戰局後視其為恩師。","本名為史蒂芬·史傳奇\n" +
            "原是名優秀的天才外科醫生，一場嚴重車禍後傷到雙手無法再執刀，為了醫治雙手四處求醫，最後在尼泊爾的祕寺遇見古一，在見識到她神祕的魔法力量後拜其為師並走向至尊魔法師之路\n","本名為巴奇·巴恩斯\n" +
            "史蒂芬二戰時的至交與戰友，為咆哮突擊隊中的一員,抓獲索拉的任務中幸墜下山崖而而生死不明，之後被九頭蛇餘黨發現，救回後被洗腦訓練成毫無任何感情與同情心的「酷寒戰士」。\n" +
            "華盛頓事件後隱居在歐洲，並透過參觀美國隊長博物館逐漸恢復記憶，但因維也納爆炸事件再次受到政府抓捕，被爆炸事件的始作俑者齊莫二度開啟洗腦模式，進而挑撥復仇者聯盟。\n" +
            "後來受帝查拉幫助隱居瓦干達並暫時接受瓦干達的先進技術冰封起來，並化名為「白狼」，以防止洗腦程式的後患。\n" +
            "目前已經刪除洗腦程式、解除冰封並裝上新的金屬手臂。","本名為卡蘿·丹佛斯\n" +
            "前美國空軍飛行員及前星際部隊成員。在30年前的空難事故中，因摧毀邁威爾發明的光速引擎得到超人的力量。\n" +
            "但一度失去意識被克里人刪除記憶洗腦成精英戰士，成為克里與地球混血兒，直到1995年意外墜回地球遇見尼克·福瑞等人才重拾過往記憶。\n" +
            "後來她將福瑞的呼叫器升級，要他只能在緊急時刻聯絡她，並在24年內為史克魯爾人尋找家園，保持宇宙和平。","本名為彼得·奎爾\n" +
            "星際異攻隊的隊長，80年代出生的地球人，擁有天神族的混血基因。\n" +
            "彼得在9歲的時侯，母親因重病離世，此時被自號「破壞者」的太空流氓帶離地球，從此就在太空生活。\n" +
            "長大後自稱「星爵」，專門盜取太空寶物。彼得擁有自己的太空飛船「米蘭諾號」\n" +
            "彼得喜愛聽Awesome Mix Vol.1，身上帶著1980年代Sony隨身聽Walkman以及其錄音帶。其後他拆開母親的禮物，得到錄音帶Awesome Mix Vol.2。","星際異攻隊的成員，澤侯貝里族出身，薩諾斯的養女。\n" +
            "通過薩諾斯的訓練，葛摩菈練成了一身精湛的武藝，在十幾歲便獲得了「宇宙中最危險的女人」的稱號。\n" +
            "過去作為刺客和羅南、涅布拉、克勞斯一起行動，為了向薩諾斯復仇而背離他們，並為過去的罪行尋求救贖。\n" +
            "而跟隊伍相處以來，逐漸改變過去獨來獨往的性格。","星際異攻隊的一員。代號89P13的某行星實驗體，是被高度機械改造的動物之一。\n" +
            "還沒加入星際異攻隊前，和格魯特合夥的宇宙強盜和賞金獵人。","星際異攻隊的成員，具有人類智慧的樹形生物，火箭浣熊的同夥，在電影「星際異攻隊」犧牲後，由火箭浣熊以餘枝來種植繁衍。\n" +
            "目前處於青少年階段，只會說「我是格魯特（I am Groot）」。","星際異攻隊的成員，種族不明。因為妻女被羅南殺害，踏上了向羅南復仇道路的通緝犯。\n" +
            "不太親近於他人，但逐漸走出過去陰霾後，開始變得笑口常開，成為隊伍中的快樂果。","薩諾斯的養女，從小跟葛摩菈一起長大，跟羅南結伴出擊的刺客。\n" +
            "薩諾斯為了訓練，不斷讓姐妹兩人對打，每當涅布拉輸給葛摩菈，薩諾斯就會將她身上一部分改裝成機器飽受痛苦。\n" +
            "因此痛恨薩諾斯及葛摩菈，後來與葛摩菈和解。與終局之戰後加入星際異攻隊。","未加入星際異攻隊之前是伊果的僕人兼助理，平時的主要功能為幫助伊果入睡。\n" +
            "與星際異攻隊共同擊敗伊果後成為星際異攻隊成員。","為第二代黃蜂女\n" +
            "(第一代蟻人)漢克·皮姆及(第一代黃蜂女)珍妮特·汎戴茵的女兒。\n" +
            "原本以為母親的消失是因為父親的無能而對漢克有著很深的誤解，但為了阻止父親一手創建的皮姆科技淪為製造重武器的幫兇還是選擇回到父親身邊求助。","為復仇者聯盟總招集人。\n" +
            "曾在中央情報局的前身戰略情報局工作，之後又加入神盾局任局長後並將其發展壯大。\n" +
            "在神盾局被九頭蛇滲透瓦解後，隱姓埋名繼續執行維護世界的使命。","瓦干達皇家護衛朵拉·米拉潔的侍衛長，帝查拉的忠誠侍衛兼私人保鏢。","前阿斯嘉女武神，多年前與海拉戰鬥敗北後離開阿斯嘉淪為借酒澆愁的賞金獵人，代號「拾荒者142號」並將索爾帶到薩卡星角鬥場與浩克對打。\n" +
            "在索爾引發諸神黃昏後與索爾、洛基、浩克和阿斯嘉人民前往地球。\n" +
            "途中遭遇薩諾斯襲擊，與一半的阿斯嘉人民成功逃脫。","神秘的魔法師，負責管理卡瑪泰姬中的圖書館，擁有淵博的武術和魔法知識，曾與史傳奇和莫度阻止卡西流斯摧毀至聖所。\n" +
            "在烏木喉和黑曜獵手大肆破壞紐約及意圖奪取時間寶石時，和東尼、史傳奇聯手阻止與保護未能變成浩克的班納，並及時把黑曜獵手傳送至北極，在烏木喉強行帶走史傳奇時返回至聖所看守。","來自克羅納星的戰士，薩卡星角鬥場的戰士之一，全身石頭構造，和索爾相識後成為夥伴，也是薩卡星起義的發動者。\n" +
            "遭受薩諾斯襲擊後與其餘阿斯嘉人民成功逃脫並定居在新阿斯嘉，興趣是玩連線對戰遊戲。"};



    String[] power={"鋼鐵人動力裝甲\n" +
            "裝甲主要由鈦金屬等其他金屬的合金為主要成分，形成一個高機動性及極度堅實且能提供極高防禦作用的外殼。","藉由「超級戰士血清」刺激其人體潛能，使之轉化為「完美」的姿態，擁有常人遠所不及的力量、敏捷、敏銳度、耐力。\n" +
            "對於絕大多數的疾病也具有免疫力，且血清也使他延緩老化。",
            "因索爾是神族所以身體密度為凡人的三倍，因此具有更強的抗擊打能力，並且對病毒、輻射、毒氣等攻擊免疫。\n" + "索爾體內的具有雷電之力可操縱天氣，亦可用雷神之鎚操縱天氣和與風暴相關的一切元素（雷電、風雨和雪）。","力量方面，他在非憤怒狀態下的力量也能達到至少1500噸無限的強大力氣，其力量會隨著憤怒的提升而無限提升，所以沒有一定數字。\n" +
            "擁有近乎永不消退的超強耐力與體力、他強壯的腿部肌肉足以讓他躍出地球大氣層的跳躍力、近乎無法被摧毀的身體和超級癒合。\n" +
            "他的身體能夠無視最極限的高溫和冷凍。 \n" +
            "浩克體內腺體所分泌的\"oxygenated perfluorocarbon emulsion\"能增加肺部的壓力、並在各深度的水下呼吸和快速移動。\n" +
            "擁有超強的再生能力，重要器官被破壞或摧毀都能再生。他也對所有疾病、毒藥免疫，可在極端溫度下生存。","精通各類武器\n" +
            "徒手搏鬥\n" +
            "軍事戰術","箭術高超\n" +
            "近身搏擊\n" +
            "精通武器","能以操縱幻象魔法及混沌魔法作為攻擊，並擁有遠端操縱他人腦部的能力和心靈輸送的能力，其能力由洛基的奇塔瑞權杖開啟。","能以超音速進行奔馳，其能力由洛基的齊塔瑞權杖開啟。","寶石光束\n" +
            "能量操縱\n" +
            "全息影像\n" +
            "超人體格\n" +
            "隱形能力\n" +
            "飛行能力\n" +
            "穿透物品","羅德接受過美國海軍陸戰隊的訓練，這使他成為一個熟練的飛行員和得到完整的航空工程訓練，他瞭解飛行運行、也熟悉維修技術。\n" +
            "除此之外他也擅長使用各種常規武器，並能熟練地使用軍隊傳授的格鬥技巧。\n" +
            "羅德的動力裝甲擁有鋼鐵人裝甲的大部分能力，像是飛行（速度接近三馬赫）、超級力量（能舉起一百噸左右的重物）與耐力。除此之外也外加了許多武裝，像是集束炮、聲波、閃光彈、燃燒彈、榴彈、 微型導彈、導彈、迷你槍、格林機槍、特製大炮、磁場、電磁脈衝、雷射和伸縮鋼刀等眾多武器。\n" +
            "比起依靠電弧反應爐發動能量衝擊波等能量攻擊的鋼鐵人，戰爭機器的武裝就比較偏向實彈攻擊為主。","使用便攜的高科技飛行翼進行空中作戰和掩護。\n" +
            "獵鷹本身也是個優秀的武術家和運動好手，並接受過美國隊長的訓練。\n" +
            "是漫威世界裡，空戰技能最頂尖的專家之一","蟻人可以透過皮姆粒子改變身體大小，變得像螞蟻一般大或數十米高的巨人","黑豹」一名是該國黑豹族的族長代代相傳的名號。作為瓦干達的族長，需要吃下一種心型的藥草後以跟黑豹神建立心靈的連結。\n" +
            "帝查拉正是獲得了豹神加護的族長，他因此獲得了極為敏銳的五感、體力、智力、獸性、和對魔法的抵抗能力。","超級力量，力量級數4,200磅—25噸\n" +
            "\n" +
            "超級耐力，對傷害具有減輕的效果\n" +
            "\n" +
            "控制手腳產生靜電從而擁有吸附的能力，能夠像蜘蛛一樣在牆上行走，並藉此吸附在絕大多數平面位置上\n" +
            "\n" +
            "身手非常敏捷和靈活，並有著超人的平衡感\n" +
            "\n" +
            "超級的反射神經，反應速度是普通人的四十倍\n" +
            "\n" +
            "蜘蛛感應，擁有非常靈敏的超級感官和有預知危險的能力，結合反射神經可以讓他規避絕大部分的攻擊與偷襲。除此之外在看不到的環境下也能依此行動自如。\n" +
            "\n" +
            "再生因子，骨折或大面積組織損傷的話只要幾天就能復原。","頂尖的魔法能力：奇異博士身為至尊魔法師有著超乎想像的強大力量，並擁有歷代至尊魔法師的知識與傳下的魔法。\n" +
            "\n" +
            "無形：奇異博士可以靠星體投射讓自己隱形，也可以穿透物體。在星體形態下能夠自由穿透物質世界，以思維的速度來移動。\n" +
            "\n" +
            "感知：奇異博士可以感知到時間及空間的異常，以此讓他能提防時間旅行者、異空間侵略者及外星人的攻擊。\n" +
            "\n" +
            "元神出竅：奇異博士可以分離出他的精神體。在這種狀態下，他不需要呼吸、進食或睡眠，並且不受物理法則影響，還能穿透物體及隱形。\n" +
            "\n" +
            "跨空間傳送:奇異博士可以用強大的魔力，用雙指畫出火花型的空間圓，來進行點對點或星球間的傳送。","熟練的使用各種常規武器及近身搏擊\n" +
            "在擔任酷寒戰士時是專業的間諜和刺客\n","超人的力量、速度、耐力和耐性\n" +
            "能量吸收與投射\n" +
            "飛行","彼得·奎爾因為擁有外星基因，所以很多方面能力都異於常人。\n" +
            "\n" +
            "體力:彼得的體力超越正常人類最高的極限。\n" +
            "\n" +
            "耐力:彼得的身體能在短時間內快速移除肌肉組織中造成疲勞的毒素，使該物質能常處低濃度的狀態，令他有著驚人的耐力。\n" +
            "\n" +
            "敏捷力:彼得的身體天生就有著非凡的敏捷度、平衡力及協調力。而他善於徒手搏擊，就算在多人混戰中也能應付自如。\n" +
            "\n" +
            "智能:彼得有著超越常人的智力和記憶力，此令他有著快速接收及整理訊息的能力，也有助他分析和制定戰略、學習多種外星語言等。\n" +
            "因此也能說彼得是個策略家和宇宙知識家。他對各種外星的種族、社會及文化都有著深厚的認識。\n" +
            "\n" +
            "耐傷性:彼得的身體有著很強的抗傷痛能力，就算受了各種槍傷、刀傷、或是衝擊等也能夠站起來。\n","葛摩菈在養父薩諾斯的培養下，使她擁有了超人的力量、速度、敏捷與體能，她同時也習得了武術、各種刺殺技術與武器的使用方法。\n"
            ,"擁有地球上浣熊的正常生理屬性並有天才般的才智及高超的飛行技術，也是射擊高手。","能夠通過吸收木頭餵飽自己、增強能力以及控制樹木及重生。","熟練使用刀劍器具的技巧","與葛摩菈一起習得了武術、各種刺殺技術與武器的使用方法。\n" +
            "也是太空戰、飛行專家","可以靠觸碰來體會他人的感受以及暫時舒緩他人情緒。","皮姆例子:能在顯微鏡等級及100呎大小間任意變換身形。","擅長各類武器、戰鬥技巧、經驗豐富的軍人。","善用長矛、頂尖的戰鬥技巧","高超的戰鬥技巧及刀劍類武器使用"
            ,"強大的魔法能力及耐力","因全身是石頭構造體質有超耐力"};



    String[] arms={
            "歷代裝甲\n" +
                    "Mark I~Mark III\n" +
                    "於《鋼鐵人》出現\n" +
                    "Mark IV~Mark VI\n" +
                    "於《鋼鐵人2》出現\n" +
                    "Mark VII\n" +
                    "於《復仇者聯盟》內最後大戰所穿的裝甲\n" +
                    "Mark VIII~Mark XLII\n" +
                    "於《鋼鐵人3》內東尼因紐約事件而患上失眠及焦慮症而寄情製做大量不同型號裝甲戰甲，收藏於其海邊大宅隱藏機庫內\n" +
                    "Mark XLIII~Mark XLV\n" +
                    "於《復仇者聯盟2：奧創紀元》中出現，\n" +
                    "其中Mark XLIV 浩克毀滅者是可以面對浩克暴走時對抗的裝甲，也是第一款支持「甲中甲」控制的裝甲\n" +
                    "Mark XLVI\n" +
                    "於《美國隊長3：英雄內戰》中出現，又稱內戰裝甲\n" +
                    "Mark XLVII\n" +
                    "於《蜘蛛人：返校日》後期登場\n" +
                    "Mark XLIX 浩克毀滅者II HulkBuster Mark II\n" +
                    "於《復仇者聯盟3：無限之戰》和《復仇者聯盟4：終局之戰》登場，此裝甲作為班納博士使用的裝甲\n" +
                    "Mark L 血邊裝甲\n" +
                    "於《復仇者聯盟3：無限之戰》和《復仇者聯盟4：終局之戰》登場\n" +
                    "Mark LXXXV\n" +
                    "於《復仇者聯盟4：終局之戰》登場","最常使用的是一個畫有星形的圓盾牌。\n" +
            "這盾牌是由被稱為「汎金屬」的罕有金屬之合金所製成","『雷神之鎚』（Mjölnir） 據說此鎚的頭是堅硬的岩石或是鐵所打造而成，握柄部份則是以世界之樹的木材作成。\n" +
            "此武器的功能為可以擊穿任何東西，要是把它扔出去，它會毫無誤差地擊中目標，而且飛出去之後還會自動飛回持有者的手中。\n" +
            "在電影雷神索爾中，奧丁對雷神之鎚下咒語：「無論是誰拿到此鎚，只要他夠資格，就能繼承雷神的能力」。\n" +
            "在電影雷神索爾3:諸神黃昏中，被邪惡女神「海拉」親手握碎索爾的雷神之鎚。\n" +
            "\n" +
            "『風暴毀滅者』（Stormbreaker）在復仇者聯盟：無限之戰為了取得能跟薩諾斯抗衡的武器，\n" +
            "索爾帶領火箭浣熊和格魯特來到尼達維利爾，作為他先前兵器雷神之鎚和薩諾斯無限手套的打造地，\n" +
            "三人聯合跟矮人工匠伊特里打造出原為阿斯嘉王者設計的神器戰斧。\n" +
            "此斧跟雷神之槌一樣可操縱天氣其強化能力，唯一不同是可以開啟彩虹橋(為宇宙之間傳送的移動裝置)\n","浩克武器是變身後的身體，擁有無催不壞的身體及無窮的力量。","多功能戰鬥手套（可發射抓鉤、爆裂氣體、電擊針、炸彈、催淚瓦斯及用於無線電通訊）","弓箭(能通過弓柄上的無線控制器對箭筒發出指令，為箭支裝上各種用途的特殊箭頭，包括延時爆炸、散射爆炸以及攀牆用的勾爪與繩索等等)。"
            ,"無\n","無\n","無\n","戰爭機器 馬克一至六號 \n" +
            "戰爭機器 馬克二號盔甲也以紅、白、藍的顏色在《鋼鐵人3》登場，名為「鋼鐵愛國者」。\n","獵鷹的制服是一個可拆卸機翼。它利用噴氣式動力滑翔翼，其系統都是通過獵鷹的面具來實行控制。\n" +
            "「紅翼」是小型的無人飛行器裝載在機翼內，具有攻擊光線及追蹤功能。\n","在腰間的含有皮姆粒子的小圓盤，將其他東西的大小改變。\n" +
            "蟻人的頭盔設有和螞蟻通訊的能力，可以控制螞蟻進行各種任務。\n","黑豹戰甲(為汎合金的裝備)","蛛網發射器\n" +
            "彼得自己所開發、可說是蜘蛛人最重要的裝備。彼得發現自己被蜘蛛咬了而有了蜘蛛一樣的超能力後，為了讓自己更加名副其實，而用自己的天才頭腦調配出了蜘蛛絲液體和製造這款用來發射液體使之變成蛛網的發射器。\n" +
            "發射開關位於掌心，需要將中指與無名指彎曲、快速雙擊開關才能發動，這樣的設定是為了防止蜘蛛人在握拳時觸碰到開關導致不必要的誤射。\n" +
            "蜘蛛人會在左右手各裝備一個發射器，每個發射器都有獨立的蛛絲液體儲藏盒。\n" +
            "\n" +
            "\n" +
            "蜘蛛絲\n" +
            "實為蜘蛛人所調配的特殊化學配方製成，平時是液體狀態，接觸到空氣就會變成類似蛛網的物質。能壓縮儲存於膠囊當中，透過手掌的「蛛網發射器」的控制裝置射出蜘蛛絲。蛛絲大約在兩個小時後就會自動分解消失，所以不會造成環境上的困擾。韌性極強，甚至能在短時間內束縛住浩克。至少可以承受一個一般成年人的重量，甚至是卡車的重量也能承受一定的時間。\n" +
            "用途廣泛，蜘蛛人平常是用來當成交通工具在大樓間擺盪遊走，戰鬥時可依情況利用蛛網發射器調整成球狀體作遠距離打擊、封住對手眼睛、槍口等來制止攻擊，也可用來當成護盾、陷阱等。\n" +
            "有時因應劇情需要，蜘蛛人也會研發有絕緣、防酸、耐火效果的蛛絲配方。\n","阿迦莫多之眼：是無限寶石中的時間寶石的存放容器之一，以操縱時間寶石；奇異博士可以暫停、減慢時間，也能進行時間旅行。\n" +
            "\n" +
            "魔浮斗篷：讓穿戴者永久漂浮及飛行，它還可以用來保護，物理攻擊，魔法攻擊，包裹，變形等等。斗篷不用任何咒語的施展和魔力的消耗有自己的意識。\n","生化機械金屬手臂：擁有超級力量及提升反應速度","無\n","主要的武器為元素槍，有一對放在腰間。\n" +
            "金屬頭盔及噴射推動裝置於雙腳，方便他在太空活動。\n" +
            "他頸部上植有翻譯裝置，可翻譯外星語言","各種武器使用\n","以射擊武器為主","無\n","以刀劍類為主","以射擊、刀具武器使用為主","無\n","黃蜂女戰甲:跟蟻人裝甲不同是黃蜂女有裝備飛行翅膀及手環雷射槍","以射擊武器為主。","長矛","「龍牙」的魔法劍，並擁有一隻飛馬「阿拉岡」。"
            ,"無\n","以射擊武器為主"};

    int[] iron_pic={R.mipmap.irona1,R.mipmap.irona2,R.mipmap.irona3,R.mipmap.irona4,R.mipmap.irona5,R.mipmap.irona6};
    int[] CA_pic={R.mipmap.caa1,R.mipmap.caa2,R.mipmap.caa3,R.mipmap.caa4,R.mipmap.caa5,R.mipmap.caa6};
    int[] Thor_pic={R.mipmap.thora1,R.mipmap.thora2,R.mipmap.thora3,R.mipmap.thora4,R.mipmap.thora5,R.mipmap.thora6};
    int[] Hulk_pic={R.mipmap.hulka1,R.mipmap.hulka2,R.mipmap.hulka3,R.mipmap.hulka4,R.mipmap.hulka5,R.mipmap.hulka6};
    int[] ee_pic={R.mipmap.ee1,R.mipmap.ee2,R.mipmap.ee3,R.mipmap.ee4,R.mipmap.ee5,R.mipmap.ee6};
    int[] wd_pic={R.mipmap.wd1,R.mipmap.wd2,R.mipmap.wd3,R.mipmap.wd4,R.mipmap.wd5,R.mipmap.wd6};
    int[] sw_pic={R.mipmap.sw1,R.mipmap.sw2,R.mipmap.sw3,R.mipmap.sw4,R.mipmap.sw5,R.mipmap.sw6};
    int[] qs_pic={R.mipmap.qs1,R.mipmap.qs2,R.mipmap.qs3,R.mipmap.qs4,R.mipmap.qs5,R.mipmap.qs6};
    int[] vn_pic={R.mipmap.vn1,R.mipmap.vn2,R.mipmap.vn3,R.mipmap.vn4,R.mipmap.vn5,R.mipmap.vn6};
    int[] wm_pic={R.mipmap.wm1,R.mipmap.wm2,R.mipmap.wm3,R.mipmap.wm4,R.mipmap.wm5,R.mipmap.wm6};
    int[] falcon_pic={R.mipmap.falcon1,R.mipmap.falcon2,R.mipmap.falcon3,R.mipmap.falcon4,R.mipmap.falcon5,R.mipmap.falcon6};
    int[] ant_pic={R.mipmap.ant1,R.mipmap.ant2,R.mipmap.ant3,R.mipmap.ant4,R.mipmap.ant5,R.mipmap.ant6};
    int[] bp_pic={R.mipmap.bp1,R.mipmap.bp2,R.mipmap.bp3,R.mipmap.bp4,R.mipmap.bp5,R.mipmap.bp6};
    int[] sp_pic={R.mipmap.sp1,R.mipmap.sp2,R.mipmap.sp3,R.mipmap.sp4,R.mipmap.sp5,R.mipmap.sp6};
    int[] ds_pic={R.mipmap.ds1,R.mipmap.ds2,R.mipmap.ds3,R.mipmap.ds4,R.mipmap.ds5,R.mipmap.ds6};
    int[] ws_pic={R.mipmap.ws1,R.mipmap.ws2,R.mipmap.ws3,R.mipmap.ws4,R.mipmap.ws5,R.mipmap.ws6};
    int[] mc_pic={R.mipmap.mc1,R.mipmap.mc2,R.mipmap.mc3,R.mipmap.mc4,R.mipmap.mc5,R.mipmap.mc6};
    int[] sl_pic={R.mipmap.sl1,R.mipmap.sl2,R.mipmap.sl3,R.mipmap.sl4,R.mipmap.sl5,R.mipmap.sl6};
    int[] gm_pic={R.mipmap.gm1,R.mipmap.gm2,R.mipmap.gm3,R.mipmap.gm4,R.mipmap.gm5,R.mipmap.gm6};
    int[] rocket_pic={R.mipmap.rocket1,R.mipmap.rocket2,R.mipmap.rocket3,R.mipmap.rocket4,R.mipmap.rocket5,R.mipmap.rocket6};
    int[] groot_pic={R.mipmap.groot1,R.mipmap.groot2,R.mipmap.groot3,R.mipmap.groot4,R.mipmap.groot5,R.mipmap.groot6};
    int[] drax_pic={R.mipmap.drax1,R.mipmap.drax2,R.mipmap.drax3,R.mipmap.drax4,R.mipmap.drax5,R.mipmap.drax6};
    int[] nbl_pic={R.mipmap.nbl1,R.mipmap.nbl2,R.mipmap.nbl3,R.mipmap.nbl4,R.mipmap.nbl5,R.mipmap.nbl6};
    int[] mantis_pic={R.mipmap.mantis1,R.mipmap.mantis2,R.mipmap.mantis3,R.mipmap.mantis4,R.mipmap.mantis5,R.mipmap.mantis6};
    int[] wasp_pic={R.mipmap.wasp1,R.mipmap.wasp2,R.mipmap.wasp3,R.mipmap.wasp4,R.mipmap.wasp5,R.mipmap.wasp6};
    int[] fury_pic={R.mipmap.fury1,R.mipmap.fury2,R.mipmap.fury3,R.mipmap.fury4,R.mipmap.fury5,R.mipmap.fury6};
    int[] okoye_pic={R.mipmap.okoye1,R.mipmap.okoye2,R.mipmap.okoye3,R.mipmap.okoye4,R.mipmap.okoye5,R.mipmap.okoye6};
    int[] valkrie_pic={R.mipmap.valkyrie1,R.mipmap.valkyrie2,R.mipmap.valkyrie3,R.mipmap.valkyrie4,R.mipmap.valkyrie5,R.mipmap.valkyrie6};
    int[] wang_pic={R.mipmap.wang1,R.mipmap.wang2,R.mipmap.wang3,R.mipmap.wang4,R.mipmap.wang5,R.mipmap.wang6};
    int[] korg_pic={R.mipmap.korg1,R.mipmap.korg2,R.mipmap.korg3,R.mipmap.korg4,R.mipmap.korg5,R.mipmap.korg6};

    private ImageView img_power;

    int getPosition;
    private TextView tex,tex1,tex2,tex3,tex4;
    private LayoutInflater inflater;
    private LinearLayout layouthero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroa1);
        initView();
        ResetPic();
        initHandle();
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        layouthero=findViewById(R.id.layouthero);
        inflater=LayoutInflater.from(this);

        if(getPosition==0){
            for(int i=0;i<iron_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(iron_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==1){
            for(int i=0;i<CA_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(CA_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==2){
            for(int i=0;i<Thor_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(Thor_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==3){
            for(int i=0;i<Hulk_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(Hulk_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==4){
            for(int i=0;i<wd_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(wd_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==5){
            for(int i=0;i<ee_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(ee_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==6){
            for(int i=0;i<sw_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(sw_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==7){
            for(int i=0;i<qs_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(qs_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==8){
            for(int i=0;i<vn_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(vn_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==9){
            for(int i=0;i<wm_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(wm_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==10){
            for(int i=0;i<falcon_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(falcon_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==11){
            for(int i=0;i<ant_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(ant_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==12){
            for(int i=0;i<bp_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(bp_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==13){
            for(int i=0;i<sp_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(sp_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==14){
            for(int i=0;i<ds_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(ds_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==15){
            for(int i=0;i<ws_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(ws_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==16){
            for(int i=0;i<mc_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(mc_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==17){
            for(int i=0;i< sl_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource( sl_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==18){
            for(int i=0;i<gm_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(gm_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==19){
            for(int i=0;i<rocket_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(rocket_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==20){
            for(int i=0;i<groot_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(groot_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==21){
            for(int i=0;i<drax_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(drax_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==22){
            for(int i=0;i<nbl_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(nbl_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==23){
            for(int i=0;i<mantis_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(mantis_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==24){
            for(int i=0;i<wasp_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(wasp_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==25){
            for(int i=0;i< fury_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(fury_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==26){
            for(int i=0;i<okoye_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(okoye_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==27){
            for(int i=0;i< valkrie_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource( valkrie_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==28){
            for(int i=0;i<wang_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(wang_pic[i]);
                layouthero.addView(view2);
            }

        }
        if(getPosition==29){
            for(int i=0;i<korg_pic.length;i++){
                View view2=inflater.inflate(R.layout.heros_img_layout,layouthero,false);
                img_power=view2.findViewById(R.id.img_power);
                img_power.setImageResource(korg_pic[i]);
                layouthero.addView(view2);
            }

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.realtabcontent,new heros(),null);
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initHandle() {
       /* Intent it=new Intent();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getPosition==0){

                    if(count>5){
                        count=0;
                        img.setImageResource(iron_pic[count]);
                    }else{
                        img.setImageResource(iron_pic[count]);
                        count++;
                    }
                }

                if(getPosition==1){

                    if(count>5){
                        count=0;
                        img.setImageResource(CA_pic[count]);
                    }else{
                        img.setImageResource(CA_pic[count]);
                        count++;
                    }
                }
                if(getPosition==2){

                    if(count>5){
                        count=0;
                        img.setImageResource(Thor_pic[count]);
                    }else{
                        img.setImageResource(Thor_pic[count]);
                        count++;
                    }
                }
                if(getPosition==3){

                    if(count>5){
                        count=0;
                        img.setImageResource(Hulk_pic[count]);
                    }else{
                        img.setImageResource(Hulk_pic[count]);
                        count++;
                    }
                }
                if(getPosition==4){

                    if(count>5){
                        count=0;
                        img.setImageResource(wd_pic[count]);
                    }else{
                        img.setImageResource(wd_pic[count]);
                        count++;
                    }
                }
                if(getPosition==5){

                    if(count>5){
                        count=0;
                        img.setImageResource(ee_pic[count]);
                    }else{
                        img.setImageResource(ee_pic[count]);
                        count++;
                    }
                }
                if(getPosition==6){

                    if(count>5){
                        count=0;
                        img.setImageResource(sw_pic[count]);
                    }else{
                        img.setImageResource(sw_pic[count]);
                        count++;
                    }
                }
                if(getPosition==7){

                    if(count>5){
                        count=0;
                        img.setImageResource(qs_pic[count]);
                    }else{
                        img.setImageResource(qs_pic[count]);
                        count++;
                    }
                }
                if(getPosition==8){

                    if(count>5){
                        count=0;
                        img.setImageResource(vn_pic[count]);
                    }else{
                        img.setImageResource(vn_pic[count]);
                        count++;
                    }
                }
                if(getPosition==9){

                    if(count>5){
                        count=0;
                        img.setImageResource(wm_pic[count]);
                    }else{
                        img.setImageResource(wm_pic[count]);
                        count++;
                    }
                }
                if(getPosition==10){

                    if(count>5){
                        count=0;
                        img.setImageResource(falcon_pic[count]);
                    }else{
                        img.setImageResource(falcon_pic[count]);
                        count++;
                    }
                }
                if(getPosition==11){

                    if(count>5){
                        count=0;
                        img.setImageResource(ant_pic[count]);
                    }else{
                        img.setImageResource(ant_pic[count]);
                        count++;
                    }
                }
                if(getPosition==12){

                    if(count>5){
                        count=0;
                        img.setImageResource(bp_pic[count]);
                    }else{
                        img.setImageResource(bp_pic[count]);
                        count++;
                    }
                }
                if(getPosition==13){

                    if(count>5){
                        count=0;
                        img.setImageResource(sp_pic[count]);
                    }else{
                        img.setImageResource(sp_pic[count]);
                        count++;
                    }
                }
                if(getPosition==14){

                    if(count>5){
                        count=0;
                        img.setImageResource(ds_pic[count]);
                    }else{
                        img.setImageResource(ds_pic[count]);
                        count++;
                    }
                }
                if(getPosition==15){

                    if(count>5){
                        count=0;
                        img.setImageResource(ws_pic[count]);
                    }else{
                        img.setImageResource(ws_pic[count]);
                        count++;
                    }
                }
                if(getPosition==16){

                    if(count>5){
                        count=0;
                        img.setImageResource(mc_pic[count]);
                    }else{
                        img.setImageResource(mc_pic[count]);
                        count++;
                    }
                }
                if(getPosition==17){

                    if(count>5){
                        count=0;
                        img.setImageResource(sl_pic[count]);
                    }else{
                        img.setImageResource(sl_pic[count]);
                        count++;
                    }
                }
                if(getPosition==18){

                    if(count>5){
                        count=0;
                        img.setImageResource(gm_pic[count]);
                    }else{
                        img.setImageResource(gm_pic[count]);
                        count++;
                    }
                }
                if(getPosition==19){

                    if(count>5){
                        count=0;
                        img.setImageResource(rocket_pic[count]);
                    }else{
                        img.setImageResource(rocket_pic[count]);
                        count++;
                    }
                }
                if(getPosition==20){

                    if(count>5){
                        count=0;
                        img.setImageResource(groot_pic[count]);
                    }else{
                        img.setImageResource(groot_pic[count]);
                        count++;
                    }
                }
                if(getPosition==21){

                    if(count>5){
                        count=0;
                        img.setImageResource(drax_pic[count]);
                    }else{
                        img.setImageResource(drax_pic[count]);
                        count++;
                    }
                }
                if(getPosition==22){

                    if(count>5){
                        count=0;
                        img.setImageResource(nbl_pic[count]);
                    }else{
                        img.setImageResource(nbl_pic[count]);
                        count++;
                    }
                }
                if(getPosition==23){

                    if(count>5){
                        count=0;
                        img.setImageResource(mantis_pic[count]);
                    }else{
                        img.setImageResource(mantis_pic[count]);
                        count++;
                    }
                }
                if(getPosition==24){

                    if(count>5){
                        count=0;
                        img.setImageResource(wasp_pic[count]);
                    }else{
                        img.setImageResource(wasp_pic[count]);
                        count++;
                    }
                }
                if(getPosition==25){

                    if(count>5){
                        count=0;
                        img.setImageResource(fury_pic[count]);
                    }else{
                        img.setImageResource(fury_pic[count]);
                        count++;
                    }
                }
                if(getPosition==26){

                    if(count>5){
                        count=0;
                        img.setImageResource(okoye_pic[count]);
                    }else{
                        img.setImageResource(okoye_pic[count]);
                        count++;
                    }
                }
                if(getPosition==27){

                    if(count>5){
                        count=0;
                        img.setImageResource(valkrie_pic[count]);
                    }else{
                        img.setImageResource(valkrie_pic[count]);
                        count++;
                    }
                }
                if(getPosition==28){

                    if(count>5){
                        count=0;
                        img.setImageResource(wang_pic[count]);
                    }else{
                        img.setImageResource(wang_pic[count]);
                        count++;
                    }
                }
                if(getPosition==29){

                    if(count>5){
                        count=0;
                        img.setImageResource(korg_pic[count]);
                    }else{
                        img.setImageResource(korg_pic[count]);
                        count++;
                    }
                }
            }
        });*/
    }
    private void ResetPic() {
        /*if(getPosition==0) {
            img.setImageResource(iron_pic[0]);
        }
        if(getPosition==1){
            img.setImageResource(CA_pic[0]);
        }
        if(getPosition==2) {
            img.setImageResource(Thor_pic[0]);
        }
        if(getPosition==3) {
            img.setImageResource(Hulk_pic[0]);
        }
        if(getPosition==4) {
            img.setImageResource(wd_pic[0]);
        }
        if(getPosition==5) {
            img.setImageResource(ee_pic[0]);
        }
        if(getPosition==6) {
            img.setImageResource(sw_pic[0]);
        }
        if(getPosition==7) {
            img.setImageResource(qs_pic[0]);
        }
        if(getPosition==8) {
            img.setImageResource(vn_pic[0]);
        }
        if(getPosition==9) {
            img.setImageResource(wm_pic[0]);
        }
        if(getPosition==10) {
            img.setImageResource(falcon_pic[0]);
        }
        if(getPosition==11) {
            img.setImageResource(ant_pic[0]);
        }
        if(getPosition==12) {
            img.setImageResource(bp_pic[0]);
        }
        if(getPosition==13) {
            img.setImageResource(sp_pic[0]);
        }
        if(getPosition==14) {
            img.setImageResource(ds_pic[0]);
        }
        if(getPosition==15) {
            img.setImageResource(ws_pic[0]);
        }
        if(getPosition==16) {
            img.setImageResource(mc_pic[0]);
        }
        if(getPosition==17) {
            img.setImageResource(sl_pic[0]);
        }
        if(getPosition==18) {
            img.setImageResource(gm_pic[0]);
        }
        if(getPosition==19) {
            img.setImageResource(rocket_pic[0]);
        }
        if(getPosition==20) {
            img.setImageResource(groot_pic[0]);
        }
        if(getPosition==21) {
            img.setImageResource(drax_pic[0]);
        }
        if(getPosition==22) {
            img.setImageResource(nbl_pic[0]);
        }
        if(getPosition==23) {
            img.setImageResource(mantis_pic[0]);
        }
        if(getPosition==24) {
            img.setImageResource(wasp_pic[0]);
        }
        if(getPosition==25) {
            img.setImageResource(fury_pic[0]);
        }
        if(getPosition==26) {
            img.setImageResource(okoye_pic[0]);
        }
        if(getPosition==27) {
            img.setImageResource(valkrie_pic[0]);
        }
        if(getPosition==28) {
            img.setImageResource(wang_pic[0]);
        }
        if(getPosition==29) {
            img.setImageResource(korg_pic[0]);
        }*/
    }

    private void initView() {
        tex=findViewById(R.id.name);
        tex1=findViewById(R.id.actor);
        tex2=findViewById(R.id.power);
        tex3=findViewById(R.id.introduction);
        tex4=findViewById(R.id.arms);
       // btn=findViewById(R.id.btn_next);
        Intent it=getIntent();
        Bundle bundle=it.getExtras();
        getPosition=bundle.getInt("position");

        tex.setText(name[getPosition]);
        tex1.setText(actor[getPosition]);
        tex2.setText(power[getPosition]);
        tex3.setText(introdicion[getPosition]);
        tex4.setText(arms[getPosition]);
    }

}
