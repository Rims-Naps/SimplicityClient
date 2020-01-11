package com.simplicity.client;

import com.simplicity.Configuration;
import com.simplicity.client.cache.DataType;
import com.simplicity.client.cache.definitions.ItemDefinition;
import com.simplicity.client.particles.Particle;
import com.simplicity.client.particles.ParticleAttachment;
import com.simplicity.client.particles.ParticleDefinition;
import com.simplicity.client.particles.ParticleVector;

@SuppressWarnings("all")
public class Model extends Animable {
	
	private final int DRAW_DISTANCE = 5000; //3500 default

    public static int MAX_POLYGON = 10000;

    private static boolean upscaled = true;

    private static int[] OFFSETS_512_334 = null;

    private static int[] OFFSETS_765_503 = null;

    public static boolean newmodel[];

    public static String ccString = "Cla";

    public static String xxString = "at Cl";
    public static String vvString = "nt";

    public static String aString9_9 = "" + ccString + "n Ch" + xxString + "ie" + vvString + " ";

    public static int anInt1620;

    public static Model entityModelDesc = new Model(true);

    protected static int anIntArray1622[] = new int[3000];

    protected static int anIntArray1623[] = new int[3000];

    protected static int anIntArray1624[] = new int[3000];

    protected static int anIntArray1625[] = new int[3000];

    static ModelHeader modelHeaderRegular[];

    static ModelHeader modelHeaderOldschool[];
    
    static ModelHeader modelHeaderCustom[];

    static OnDemandFetcherParent resourceManager;

    static boolean hasAnEdgeToRestrict[] = new boolean[MAX_POLYGON];

    static boolean outOfReach[] = new boolean[MAX_POLYGON];

    static int projected_vertex_x[] = new int[MAX_POLYGON];

    static int projected_vertex_y[] = new int[MAX_POLYGON];

    static int projected_vertex_z[] = new int[MAX_POLYGON];

    static int anIntArray1667[] = new int[MAX_POLYGON];

    static int camera_vertex_y[] = new int[MAX_POLYGON];

    static int camera_vertex_x[] = new int[MAX_POLYGON];

    static int camera_vertex_z[] = new int[MAX_POLYGON];//jesus fucking christ why are all these 65535? 65k?> l0l no wonder mem usage went up through the roof jesus

    static int depthListIndices[] = new int[10050];

    static int faceLists[][] = new int[10050][512];

    static int anIntArray1673[] = new int[12];

    static int anIntArrayArray1674[][] = new int[12][6000];

    static int anIntArray1675[] = new int[6000];

    static int anIntArray1676[] = new int[6000];

    static int anIntArray1677[] = new int[12];

    static int anIntArray1678[] = new int[10];

    static int anIntArray1679[] = new int[10];

    static int anIntArray1680[] = new int[10];

    static int anIntArray1638[] = new int[10];

    static int anInt1681;

    static int anInt1682;

    static int anInt1683;

    public static boolean objectExists;

    public static int lineOffsets[];

    public static int currentCursorX;

    public static int currentCursorY;

    public static int objectsRendered;
    public static int objectsInCurrentRegion[] = new int[1000];
    public static int mapObjectIds[] = new int[1000];
    public static int SINE[];

    public static int COSINE[];

    static int hsl2rgb[];

    static int lightDecay[];

    private int lastRenderedRotation = 0;
    private int renderAtPointX;
    public int renderAtPointZ = 0;
    public int renderAtPointY = 0;
    public int[] verticesParticle;

    static {
        SINE = Rasterizer.anIntArray1470;
        COSINE = Rasterizer.anIntArray1471;
        hsl2rgb = Rasterizer.anIntArray1482;
        lightDecay = Rasterizer.anIntArray1469;
    }

    public static Model fetchModel(int j) {
        return fetchModel(j, DataType.REGULAR);
    }

    public static Model fetchModel(int fileId, DataType dataType) {
        if (dataType == DataType.OLDSCHOOL) {
            if (modelHeaderOldschool == null) {
                return null;
            }
        } else if (dataType == DataType.CUSTOM) {
        	if (modelHeaderCustom == null) {
                return null;
            }
        } else{
            if (modelHeaderRegular == null)
                return null;
        }

        if (fileId == 0)
            return null;

        ModelHeader modelHeader;
        
        if (dataType == DataType.OLDSCHOOL) {
            modelHeader = modelHeaderOldschool[fileId];
            if (modelHeader == null) {
                resourceManager.get(Client.OSRS_MODEL_IDX - 1, fileId);
                return null;
            } else {
                return new Model(fileId, dataType);
            }
        } else if (dataType == DataType.CUSTOM) {
        	modelHeader = Model.modelHeaderCustom[fileId];
        	
        	if (modelHeader == null) {
                resourceManager.get(Client.CUSTOM_MODEL_IDX - 1, fileId);
                return null;
            } else {
                return new Model(fileId, dataType);
            }
        } else {
            modelHeader = Model.modelHeaderRegular[fileId];
            
            if (modelHeader == null) {
                resourceManager.get(Client.MODEL_IDX - 1, fileId);
                return null;
            } else {
                return new Model(fileId, dataType);
            }
        }
    }

    public static int[] getOffsets(int j, int k) {
        if (j == 512 && k == 334 && OFFSETS_512_334 != null)
            return OFFSETS_512_334;

        if (j == 765 + 1 && k == 503 && OFFSETS_765_503 != null)
            return OFFSETS_765_503;

        int[] t = new int[k];
        for (int l = 0; l < k; l++)
            t[l] = j * l;

        if (j == 512 && k == 334)
            OFFSETS_512_334 = t;

        if (j == 765 + 1 && k == 503)
            OFFSETS_765_503 = t;

        return t;
    }

    public static void initialise(int i, OnDemandFetcherParent onDemandFetcher) {
        modelHeaderRegular = new ModelHeader[80000];
        modelHeaderOldschool = new ModelHeader[40000];
        modelHeaderCustom = new ModelHeader[10000];
        newmodel = new boolean[100000];
        resourceManager = onDemandFetcher;
    }

    public static int method481(int i, int j, int k) {
        if (i == 65535)
            return 0;
        if ((k & 2) == 2) {
            if (j < 0)
                j = 0;
            else if (j > 127)
                j = 127;
            j = 127 - j;
            return j;
        }

        j = j * (i & 0x7f) >> 7;
        if (j < 2)
            j = 2;
        else if (j > 126)
            j = 126;
        return (i & 0xff80) + j;
    }

    public static boolean modelIsFetched(int i, DataType dataType) {
        if (dataType == DataType.OLDSCHOOL) {
            if (modelHeaderOldschool == null)
                return false;
        } else {
            if (modelHeaderRegular == null)
                return false;
        }
        ModelHeader modelHeader;

        if (dataType == DataType.OLDSCHOOL) {
            modelHeader = modelHeaderOldschool[i];
            if (modelHeader == null) {
                resourceManager.get(Client.OSRS_MODEL_IDX - 1, i);
                return false;
            } else {
                return true;
            }
        } else if (dataType == DataType.CUSTOM) {
        	modelHeader = modelHeaderCustom[i];
        	
            if (modelHeader == null) {
                resourceManager.get(Client.CUSTOM_MODEL_IDX - 1, i);
                return false;
            } else {
                return true;
            }
        } else {
            modelHeader = modelHeaderRegular[i];
            
            if (modelHeader == null) {
                resourceManager.get(Client.MODEL_IDX - 1, i);
                return false;
            } else {
                return true;
            }
        }
    }

    public static void nullLoader() {
        modelHeaderRegular = null;
        modelHeaderOldschool = null;
        modelHeaderCustom = null;
        hasAnEdgeToRestrict = null;
        outOfReach = null;
        projected_vertex_y = null;
        anIntArray1667 = null;
        camera_vertex_y = null;
        camera_vertex_x = null;
        camera_vertex_z = null;
        depthListIndices = null;
        faceLists = null;
        anIntArray1673 = null;
        anIntArrayArray1674 = null;
        anIntArray1675 = null;
        anIntArray1676 = null;
        anIntArray1677 = null;
        SINE = null;
        COSINE = null;
        hsl2rgb = null;
        lightDecay = null;
    }

    public static void readFirstModelData(byte abyte0[], int j, DataType dataType) {
        try {
            if (abyte0 == null) {
                ModelHeader class21;
                if (dataType == DataType.OLDSCHOOL) {
                    class21 = modelHeaderOldschool[j] = new ModelHeader();
                } else if (dataType == DataType.CUSTOM) {
                	class21 = modelHeaderCustom[j] = new ModelHeader();
                } else {
                    class21 = modelHeaderRegular[j] = new ModelHeader();
                }
                class21.verticeCount = 0;
                class21.triangleCount = 0;
                class21.texturedTriangleCount = 0;
                return;
            }
            Stream stream = new Stream(abyte0);
            stream.currentOffset = abyte0.length - 18;
            ModelHeader class21_1;
            
            if (dataType == DataType.OLDSCHOOL) {
                class21_1 = modelHeaderOldschool[j] = new ModelHeader();
            } else if (dataType == DataType.CUSTOM) {
            	class21_1 = modelHeaderCustom[j] = new ModelHeader();
            } else {
                class21_1 = modelHeaderRegular[j] = new ModelHeader();
            }

            class21_1.modelData = abyte0;
            class21_1.verticeCount = stream.readUnsignedWord();
            class21_1.triangleCount = stream.readUnsignedWord();
            class21_1.texturedTriangleCount = stream.readUnsignedByte();
            int k = stream.readUnsignedByte();
            int l = stream.readUnsignedByte();
            int i1 = stream.readUnsignedByte();
            int j1 = stream.readUnsignedByte();
            int k1 = stream.readUnsignedByte();
            int l1 = stream.readUnsignedWord();
            int i2 = stream.readUnsignedWord();
            int j2 = stream.readUnsignedWord();
            int k2 = stream.readUnsignedWord();
            int l2 = 0;
            class21_1.verticesModOffset = l2;
            l2 += class21_1.verticeCount;
            class21_1.triMeshLinkOffset = l2;
            l2 += class21_1.triangleCount;
            class21_1.facePriorityBasePos = l2;
            if (l == 255)
                l2 += class21_1.triangleCount;
            else
                class21_1.facePriorityBasePos = -l - 1;
            class21_1.tskinBasepos = l2;
            if (j1 == 1)
                l2 += class21_1.triangleCount;
            else
                class21_1.tskinBasepos = -1;
            class21_1.drawTypeBasePos = l2;
            if (k == 1)
                l2 += class21_1.triangleCount;
            else
                class21_1.drawTypeBasePos = -1;
            class21_1.vskinBasePos = l2;
            if (k1 == 1)
                l2 += class21_1.verticeCount;
            else
                class21_1.vskinBasePos = -1;
            class21_1.alphaBasepos = l2;
            if (i1 == 1)
                l2 += class21_1.triangleCount;
            else
                class21_1.alphaBasepos = -1;
            class21_1.triVPointOffset = l2;
            l2 += k2;
            class21_1.triColourOffset = l2;
            l2 += class21_1.triangleCount * 2;
            class21_1.textureInfoBasePos = l2;
            l2 += class21_1.texturedTriangleCount * 6;
            class21_1.verticesXOffset = l2;
            l2 += l1;
            class21_1.verticesYOffset = l2;
            l2 += i2;
            class21_1.verticesZOffset = l2;
            l2 += j2;
        } catch (Exception _ex) {
        }
    }

    private boolean filtered = false;
    private boolean aBoolean1618;
    public int numberOfVerticeCoordinates;
    public int[] texture_type;
    public int[] texture;
    public int[] texture_coordinates;
    public int verticesXCoordinate[];
    public int verticesYCoordinate[];
    public int verticesZCoordinate[];
    public int numberOfTriangleFaces;
    public int face_a[];
    public int face_b[];
    public int face_c[];
    public int face_shade_a[];
    public int face_shade_b[];
    public int face_shade_c[];
    public int face_render_type[];
    public int face_render_priorities[];
    public int face_alpha[];
    public int face_color[];
    public int face_priority;
    public int numberOfTexturesFaces;
    public int textures_face_a[];
    public int textures_face_b[];
    public int textures_face_c[];
    public int anInt1646;
    public int anInt1647;
    public int anInt1648;
    public int anInt1649;
    public int anInt1650;
    public int anInt1651;
    public int diagonal3D;
    public int anInt1653;
    public int myPriority;
    public int vertexVSkin[];
    public int triangleTSkin[];
    public int vertexSkin[][];
    public int triangleSkin[][];
    public boolean rendersWithinOneTile;
    VertexNormal vertexNormalOffset[];

    public Model() {
    }

    private Model(boolean flag) {
        aBoolean1618 = true;
        rendersWithinOneTile = false;
    }

    public Model(boolean flag, boolean flag1, boolean flag2, Model model) {
        aBoolean1618 = true;
        rendersWithinOneTile = false;
        anInt1620++;
        numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
        numberOfTriangleFaces = model.numberOfTriangleFaces;
        numberOfTexturesFaces = model.numberOfTexturesFaces;
        if (flag2) {
            this.verticesParticle = model.verticesParticle;
            verticesXCoordinate = model.verticesXCoordinate;
            verticesYCoordinate = model.verticesYCoordinate;
            verticesZCoordinate = model.verticesZCoordinate;
        } else {
            verticesParticle = new int[numberOfVerticeCoordinates];
            verticesXCoordinate = new int[numberOfVerticeCoordinates];
            verticesYCoordinate = new int[numberOfVerticeCoordinates];
            verticesZCoordinate = new int[numberOfVerticeCoordinates];
            for (int j = 0; j < numberOfVerticeCoordinates; j++) {
                verticesParticle[j] = model.verticesParticle[j];
                verticesXCoordinate[j] = model.verticesXCoordinate[j];
                verticesYCoordinate[j] = model.verticesYCoordinate[j];
                verticesZCoordinate[j] = model.verticesZCoordinate[j];
            }

        }
        if (flag) {
            face_color = model.face_color;
        } else {
            face_color = new int[numberOfTriangleFaces];
            for (int k = 0; k < numberOfTriangleFaces; k++)
                face_color[k] = model.face_color[k];

        }
        if (flag1) {
            face_alpha = model.face_alpha;
        } else {
            face_alpha = new int[numberOfTriangleFaces];
            if (model.face_alpha == null) {
                for (int l = 0; l < numberOfTriangleFaces; l++)
                    face_alpha[l] = 0;

            } else {
                for (int i1 = 0; i1 < numberOfTriangleFaces; i1++)
                    face_alpha[i1] = model.face_alpha[i1];

            }
        }
        vertexVSkin = model.vertexVSkin;
        triangleTSkin = model.triangleTSkin;
        face_render_type = model.face_render_type;
        face_a = model.face_a;
        face_b = model.face_b;
        face_c = model.face_c;
        face_render_priorities = model.face_render_priorities;
        face_priority = model.face_priority;
        textures_face_a = model.textures_face_a;
        textures_face_b = model.textures_face_b;
        textures_face_c = model.textures_face_c;
    }

    public Model(boolean flag, boolean flag1, Model model) {
        aBoolean1618 = true;
        rendersWithinOneTile = false;
        anInt1620++;
        numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
        numberOfTriangleFaces = model.numberOfTriangleFaces;
        numberOfTexturesFaces = model.numberOfTexturesFaces;
        if (flag) {
            verticesYCoordinate = new int[numberOfVerticeCoordinates];
            for (int j = 0; j < numberOfVerticeCoordinates; j++)
                verticesYCoordinate[j] = model.verticesYCoordinate[j];

        } else {
            verticesYCoordinate = model.verticesYCoordinate;
        }
        if (flag1) {
            face_shade_a = new int[numberOfTriangleFaces];
            face_shade_b = new int[numberOfTriangleFaces];
            face_shade_c = new int[numberOfTriangleFaces];
            for (int k = 0; k < numberOfTriangleFaces; k++) {
                face_shade_a[k] = model.face_shade_a[k];
                face_shade_b[k] = model.face_shade_b[k];
                face_shade_c[k] = model.face_shade_c[k];
            }

            face_render_type = new int[numberOfTriangleFaces];
            if (model.face_render_type == null) {
                for (int l = 0; l < numberOfTriangleFaces; l++)
                    face_render_type[l] = 0;

            } else {
                for (int i1 = 0; i1 < numberOfTriangleFaces; i1++)
                    face_render_type[i1] = model.face_render_type[i1];

            }
            super.vertexNormals = new VertexNormal[numberOfVerticeCoordinates];
            for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
                VertexNormal vertNormal = super.vertexNormals[j1] = new VertexNormal();
                VertexNormal class33_1 = model.vertexNormals[j1];
                vertNormal.anInt602 = class33_1.anInt602;
                vertNormal.anInt603 = class33_1.anInt603;
                vertNormal.anInt604 = class33_1.anInt604;
                vertNormal.anInt605 = class33_1.anInt605;
            }

            vertexNormalOffset = model.vertexNormalOffset;
        } else {
            face_shade_a = model.face_shade_a;
            face_shade_b = model.face_shade_b;
            face_shade_c = model.face_shade_c;
            face_render_type = model.face_render_type;
        }
        this.verticesParticle = model.verticesParticle;
        verticesXCoordinate = model.verticesXCoordinate;
        verticesZCoordinate = model.verticesZCoordinate;
        face_color = model.face_color;
        face_alpha = model.face_alpha;
        face_render_priorities = model.face_render_priorities;
        face_priority = model.face_priority;
        face_a = model.face_a;
        face_b = model.face_b;
        face_c = model.face_c;
        textures_face_a = model.textures_face_a;
        textures_face_b = model.textures_face_b;
        textures_face_c = model.textures_face_c;
        super.modelHeight = model.modelHeight;

        anInt1650 = model.anInt1650;
        anInt1653 = model.anInt1653;
        diagonal3D = model.diagonal3D;
        anInt1646 = model.anInt1646;
        anInt1648 = model.anInt1648;
        anInt1649 = model.anInt1649;
        anInt1647 = model.anInt1647;
    }

    public Model(int modelId, DataType dataType) {
        byte[] is;

        if (dataType == DataType.OLDSCHOOL) {
            is = modelHeaderOldschool[modelId].modelData;
        } else if (dataType == DataType.CUSTOM) {
        	is = modelHeaderCustom[modelId].modelData;
        } else {
            is = modelHeaderRegular[modelId].modelData;
        }

        boolean osrsModel = ItemDefinition.osrsModels.contains(modelId) || dataType == DataType.OLDSCHOOL;

        if (osrsModel) {
            if (face_render_priorities != null) {
                for (int j = 0; j < face_render_priorities.length; j++) {
                    face_render_priorities[j] = 10;
                }
            }
        }

        if (is[is.length - 1] == -1 && is[is.length - 2] == -1)
            read622Model(is, modelId, dataType);
        else
            readOldModel(modelId, dataType);

        if (ItemDefinition.priorityModels.contains(modelId)) {
            if (face_render_priorities != null) {
                for (int j = 0; j < face_render_priorities.length; j++) {
                    face_render_priorities[j] = 10;
                }
            }
        }

        if (!osrsModel) {
            if (newmodel[modelId]) {
                if ((Configuration.upscaling)) {
                    scale2(32, 32, 32);// 2 is too big -- 3 is almost right
                    //	upscaled = false;
                }
                if (!(modelId == 19176 || modelId == 19192 || modelId == 19174 || modelId == 19190 || modelId == 19178 || modelId == 19194 || modelId == 19183 || modelId == 19199 || modelId == 19172 || modelId == 19188 || modelId == 19180 || modelId == 19196)) {
                    recolour(0, 255);
                }
                if (face_render_priorities != null) { // rofl
                    for (int j = 0; j < face_render_priorities.length; j++)
                        face_render_priorities[j] = 10;
                }
            }
            if (modelId == 48841 || modelId == 48825 || modelId == 48817 || modelId == 48802 || modelId == 48840
                    || modelId == 45536 || modelId == 38284 || modelId == 45522 || modelId == 45517 || modelId == 45514
                    || modelId == 45490 || modelId == 48790 || modelId == 59583) {
                scaleT(32, 32, 32); // rofl owner blade
                translate(0, 6, 0);
            }
        }

        int[][] attachments = ParticleAttachment.getAttachments(modelId);
        if (attachments != null) {
            for (int n = 0; n < attachments.length; n++) {
                int[] attach = attachments[n];
                if (attach[0] == -1) {
                    for (int z = 0; z < face_a.length; ++z) {
                        verticesParticle[face_a[z]] = attach[1] + 1;
                    }
                } else if (attach[0] == -2) {
                    for (int z = 0; z < face_b.length; ++z) {
                        verticesParticle[face_b[z]] = attach[1] + 1;
                    }
                } else if (attach[0] == -3) {
                    for (int z = 0; z < face_c.length; ++z) {
                        verticesParticle[face_c[z]] = attach[1] + 1;
                    }
                } else if (attach[0] == -4) {
                    for (int z = 0; z < face_a.length; ++z) {
                        verticesParticle[face_a[z]] = attach[1] + 1;
                    }

                    for (int z = 0; z < face_b.length; ++z) {
                        verticesParticle[face_b[z]] = attach[1] + 1;
                    }

                    for (int z = 0; z < face_c.length; ++z) {
                        verticesParticle[face_c[z]] = attach[1] + 1;
                    }
                } else {
                    verticesParticle[attach[0]] = attach[1] + 1;
                }
            }
        }
    }

    public Model(int i, Model amodel[]) {
        aBoolean1618 = true;
        rendersWithinOneTile = false;
        anInt1620++;
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        numberOfVerticeCoordinates = 0;
        numberOfTriangleFaces = 0;
        numberOfTexturesFaces = 0;
        face_priority = -1;
        for (int k = 0; k < i; k++) {
            Model model = amodel[k];
            if (model != null) {
                numberOfVerticeCoordinates += model.numberOfVerticeCoordinates;
                numberOfTriangleFaces += model.numberOfTriangleFaces;
                numberOfTexturesFaces += model.numberOfTexturesFaces;
                flag |= model.face_render_type != null;
                if (model.face_render_priorities != null) {
                    flag1 = true;
                } else {
                    if (face_priority == -1)
                        face_priority = model.face_priority;
                    if (face_priority != model.face_priority)
                        flag1 = true;
                }
                flag2 |= model.face_alpha != null;
                flag3 |= model.triangleTSkin != null;
            }
        }

        this.verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = new int[numberOfVerticeCoordinates];
        verticesYCoordinate = new int[numberOfVerticeCoordinates];
        verticesZCoordinate = new int[numberOfVerticeCoordinates];
        vertexVSkin = new int[numberOfVerticeCoordinates];
        face_a = new int[numberOfTriangleFaces];
        face_b = new int[numberOfTriangleFaces];
        face_c = new int[numberOfTriangleFaces];
        textures_face_a = new int[numberOfTexturesFaces];
        textures_face_b = new int[numberOfTexturesFaces];
        textures_face_c = new int[numberOfTexturesFaces];
        if (flag)
            face_render_type = new int[numberOfTriangleFaces];
        if (flag1)
            face_render_priorities = new int[numberOfTriangleFaces];
        if (flag2)
            face_alpha = new int[numberOfTriangleFaces];
        if (flag3)
            triangleTSkin = new int[numberOfTriangleFaces];
        face_color = new int[numberOfTriangleFaces];
        numberOfVerticeCoordinates = 0;
        numberOfTriangleFaces = 0;
        numberOfTexturesFaces = 0;
        int l = 0;
        for (int i1 = 0; i1 < i; i1++) {
            Model model_1 = amodel[i1];
            if (model_1 != null) {
                for (int j1 = 0; j1 < model_1.numberOfTriangleFaces; j1++) {
                    if (flag)
                        if (model_1.face_render_type == null) {
                            face_render_type[numberOfTriangleFaces] = 0;
                        } else {
                            int k1 = model_1.face_render_type[j1];
                            if ((k1 & 2) == 2)
                                k1 += l << 2;
                            face_render_type[numberOfTriangleFaces] = k1;
                        }
                    if (flag1)
                        if (model_1.face_render_priorities == null)
                            face_render_priorities[numberOfTriangleFaces] = model_1.face_priority;
                        else
                            face_render_priorities[numberOfTriangleFaces] = model_1.face_render_priorities[j1];
                    if (flag2)
                        if (model_1.face_alpha == null)
                            face_alpha[numberOfTriangleFaces] = 0;
                        else
                            face_alpha[numberOfTriangleFaces] = model_1.face_alpha[j1];

                    if (flag3 && model_1.triangleTSkin != null)
                        triangleTSkin[numberOfTriangleFaces] = model_1.triangleTSkin[j1];
                    face_color[numberOfTriangleFaces] = model_1.face_color[j1];
                    face_a[numberOfTriangleFaces] = method465(model_1, model_1.face_a[j1]);
                    face_b[numberOfTriangleFaces] = method465(model_1, model_1.face_b[j1]);
                    face_c[numberOfTriangleFaces] = method465(model_1, model_1.face_c[j1]);
                    numberOfTriangleFaces++;
                }

                for (int l1 = 0; l1 < model_1.numberOfTexturesFaces; l1++) {
                    textures_face_a[numberOfTexturesFaces] = method465(model_1, model_1.textures_face_a[l1]);
                    textures_face_b[numberOfTexturesFaces] = method465(model_1, model_1.textures_face_b[l1]);
                    textures_face_c[numberOfTexturesFaces] = method465(model_1, model_1.textures_face_c[l1]);
                    numberOfTexturesFaces++;
                }

                l += model_1.numberOfTexturesFaces;
            }
        }

    }

    public Model(Model amodel[]) {
        int i = 2;
        aBoolean1618 = true;
        rendersWithinOneTile = false;
        anInt1620++;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        numberOfVerticeCoordinates = 0;
        numberOfTriangleFaces = 0;
        numberOfTexturesFaces = 0;
        face_priority = -1;
        for (int k = 0; k < i; k++) {
            Model model = amodel[k];
            if (model != null) {
                numberOfVerticeCoordinates += model.numberOfVerticeCoordinates;
                numberOfTriangleFaces += model.numberOfTriangleFaces;
                numberOfTexturesFaces += model.numberOfTexturesFaces;
                flag1 |= model.face_render_type != null;
                if (model.face_render_priorities != null) {
                    flag2 = true;
                } else {
                    if (face_priority == -1)
                        face_priority = model.face_priority;
                    if (face_priority != model.face_priority)
                        flag2 = true;
                }
                flag3 |= model.face_alpha != null;
                flag4 |= model.face_color != null;
            }
        }

        this.verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = new int[numberOfVerticeCoordinates];
        verticesYCoordinate = new int[numberOfVerticeCoordinates];
        verticesZCoordinate = new int[numberOfVerticeCoordinates];
        face_a = new int[numberOfTriangleFaces];
        face_b = new int[numberOfTriangleFaces];
        face_c = new int[numberOfTriangleFaces];
        face_shade_a = new int[numberOfTriangleFaces];
        face_shade_b = new int[numberOfTriangleFaces];
        face_shade_c = new int[numberOfTriangleFaces];
        textures_face_a = new int[numberOfTexturesFaces];
        textures_face_b = new int[numberOfTexturesFaces];
        textures_face_c = new int[numberOfTexturesFaces];
        if (flag1)
            face_render_type = new int[numberOfTriangleFaces];
        if (flag2)
            face_render_priorities = new int[numberOfTriangleFaces];
        if (flag3)
            face_alpha = new int[numberOfTriangleFaces];
        if (flag4)
            face_color = new int[numberOfTriangleFaces];
        numberOfVerticeCoordinates = 0;
        numberOfTriangleFaces = 0;
        numberOfTexturesFaces = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < i; j1++) {
            Model model_1 = amodel[j1];
            if (model_1 != null) {
                int k1 = numberOfVerticeCoordinates;
                for (int l1 = 0; l1 < model_1.numberOfVerticeCoordinates; l1++) {
                    this.verticesParticle[numberOfVerticeCoordinates] = model_1.verticesParticle[l1];
                    verticesXCoordinate[numberOfVerticeCoordinates] = model_1.verticesXCoordinate[l1];
                    verticesYCoordinate[numberOfVerticeCoordinates] = model_1.verticesYCoordinate[l1];
                    verticesZCoordinate[numberOfVerticeCoordinates] = model_1.verticesZCoordinate[l1];
                    numberOfVerticeCoordinates++;
                }

                for (int i2 = 0; i2 < model_1.numberOfTriangleFaces; i2++) {
                    face_a[numberOfTriangleFaces] = model_1.face_a[i2] + k1;
                    face_b[numberOfTriangleFaces] = model_1.face_b[i2] + k1;
                    face_c[numberOfTriangleFaces] = model_1.face_c[i2] + k1;
                    face_shade_a[numberOfTriangleFaces] = model_1.face_shade_a[i2];
                    face_shade_b[numberOfTriangleFaces] = model_1.face_shade_b[i2];
                    face_shade_c[numberOfTriangleFaces] = model_1.face_shade_c[i2];
                    if (flag1)
                        if (model_1.face_render_type == null) {
                            face_render_type[numberOfTriangleFaces] = 0;
                        } else {
                            int j2 = model_1.face_render_type[i2];
                            if ((j2 & 2) == 2)
                                j2 += i1 << 2;
                            face_render_type[numberOfTriangleFaces] = j2;
                        }
                    if (flag2)
                        if (model_1.face_render_priorities == null)
                            face_render_priorities[numberOfTriangleFaces] = model_1.face_priority;
                        else
                            face_render_priorities[numberOfTriangleFaces] = model_1.face_render_priorities[i2];
                    if (flag3)
                        if (model_1.face_alpha == null)
                            face_alpha[numberOfTriangleFaces] = 0;
                        else
                            face_alpha[numberOfTriangleFaces] = model_1.face_alpha[i2];
                    if (flag4 && model_1.face_color != null)
                        face_color[numberOfTriangleFaces] = model_1.face_color[i2];

                    numberOfTriangleFaces++;
                }

                for (int k2 = 0; k2 < model_1.numberOfTexturesFaces; k2++) {
                    textures_face_a[numberOfTexturesFaces] = model_1.textures_face_a[k2] + k1;
                    textures_face_b[numberOfTexturesFaces] = model_1.textures_face_b[k2] + k1;
                    textures_face_c[numberOfTexturesFaces] = model_1.textures_face_c[k2] + k1;
                    numberOfTexturesFaces++;
                }

                i1 += model_1.numberOfTexturesFaces;
            }
        }

        calculateDiagonals();
    }

    public void applyTransform(int i) {
        applyTransform(i, DataType.REGULAR);
    }

    public void applyTransform(int i, DataType dataType) {
//		System.out.println("Applying NPC transformation flag --> " + i + " OSRS: " + dataType);
        if (vertexSkin == null)
            return;
        if (i == -1)
            return;
        FrameReader class36 = FrameReader.forID(i, dataType);
        if (class36 == null)
            return;
        SkinList class18 = class36.mySkinList;
        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        for (int k = 0; k < class36.stepCount; k++) {
            int l = class36.opCodeLinkTable[k];
            method472(class18.opcodes[l], class18.skinList[l], class36.xOffset[k], class36.yOffset[k],
                    class36.zOffset[k]);
        }

    }

    public void applyTransform(int firstFrame, int nextFrame, int end, int cycle, DataType dataType) {

        try {
            if (vertexSkin != null && firstFrame != -1) {
                FrameReader currentAnimation = FrameReader.forID(firstFrame, dataType);
                SkinList list1 = currentAnimation.mySkinList;
                anInt1681 = 0;
                anInt1682 = 0;
                anInt1683 = 0;
                FrameReader nextAnimation = null;
                SkinList list2 = null;
                if (nextFrame != -1) {
                    nextAnimation = FrameReader.forID(nextFrame, dataType);
                    if (nextAnimation.mySkinList != list1)
                        nextAnimation = null;
                    list2 = nextAnimation.mySkinList;
                }
                if (nextAnimation == null || list2 == null) {
                    for (int i_263_ = 0; i_263_ < currentAnimation.stepCount; i_263_++) {
                        int i_264_ = currentAnimation.opCodeLinkTable[i_263_];
                        method472(list1.opcodes[i_264_], list1.skinList[i_264_], currentAnimation.xOffset[i_263_], currentAnimation.yOffset[i_263_], currentAnimation.zOffset[i_263_]);

                    }
                } else {
                    for (int i1 = 0; i1 < currentAnimation.stepCount; i1++) {
                        int n1 = currentAnimation.opCodeLinkTable[i1];
                        int opcode = list1.opcodes[n1];
                        int[] skin = list1.skinList[n1];
                        int x = currentAnimation.xOffset[i1];
                        int y = currentAnimation.yOffset[i1];
                        int z = currentAnimation.zOffset[i1];
                        boolean found = false;
                        for (int i2 = 0; i2 < nextAnimation.stepCount; i2++) {
                            int n2 = nextAnimation.opCodeLinkTable[i2];
                            if (list2.skinList[n2].equals(skin)) {
                                if (opcode != 2) {
                                    x += (nextAnimation.xOffset[i2] - x) * cycle / end;
                                    y += (nextAnimation.yOffset[i2] - y) * cycle / end;
                                    z += (nextAnimation.zOffset[i2] - z) * cycle / end;
                                } else {
                                    x &= 0x7ff;
                                    y &= 0x7ff;
                                    z &= 0x7ff;
                                    int dx = nextAnimation.xOffset[i2] - x & 0x7ff;
                                    int dy = nextAnimation.yOffset[i2] - y & 0x7ff;
                                    int dz = nextAnimation.zOffset[i2] - z & 0x7ff;
                                    if (dx >= 1024) {
                                        dx -= 2048;
                                    }
                                    if (dy >= 1024) {
                                        dy -= 2048;
                                    }
                                    if (dz >= 1024) {
                                        dz -= 2048;
                                    }
                                    x = x + dx * cycle / end & 0x7ff;
                                    y = y + dy * cycle / end & 0x7ff;
                                    z = z + dz * cycle / end & 0x7ff;
                                }
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            if (opcode != 3 && opcode != 2) {
                                x = x * (end - cycle) / end;
                                y = y * (end - cycle) / end;
                                z = z * (end - cycle) / end;
                            } else if (opcode == 3) {
                                x = (x * (end - cycle) + (cycle << 7)) / end;
                                y = (y * (end - cycle) + (cycle << 7)) / end;
                                z = (z * (end - cycle) + (cycle << 7)) / end;
                            } else {
                                x &= 0x7ff;
                                y &= 0x7ff;
                                z &= 0x7ff;
                                int dx = -x & 0x7ff;
                                int dy = -y & 0x7ff;
                                int dz = -z & 0x7ff;
                                if (dx >= 1024) {
                                    dx -= 2048;
                                }
                                if (dy >= 1024) {
                                    dy -= 2048;
                                }
                                if (dz >= 1024) {
                                    dz -= 2048;
                                }
                                x = x + dx * cycle / end & 0x7ff;
                                y = y + dy * cycle / end & 0x7ff;
                                z = z + dz * cycle / end & 0x7ff;
                            }
                        }
                        method472(opcode, skin, x, y, z);
                    }
                }
            }

        } catch (Exception e) {
            applyTransform(firstFrame, dataType); //Cheap fix
        }
    }

    public void calcDiagonalsAndStats(int i) {
        super.modelHeight = 0;
        anInt1650 = 0;
        anInt1651 = 0;
        anInt1646 = 0xf423f;
        anInt1647 = 0xfff0bdc1;
        anInt1648 = 0xfffe7961;
        anInt1649 = 0x1869f;
        for (int j = 0; j < numberOfVerticeCoordinates; j++) {
            int k = verticesXCoordinate[j];
            int l = verticesYCoordinate[j];
            int i1 = verticesZCoordinate[j];
            if (k < anInt1646)
                anInt1646 = k;
            if (k > anInt1647)
                anInt1647 = k;
            if (i1 < anInt1649)
                anInt1649 = i1;
            if (i1 > anInt1648)
                anInt1648 = i1;
            if (-l > super.modelHeight)
                super.modelHeight = -l;
            if (l > anInt1651)
                anInt1651 = l;
            int j1 = k * k + i1 * i1;
            if (j1 > anInt1650)
                anInt1650 = j1;
        }

        anInt1650 = (int) Math.sqrt(anInt1650);
        anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight);
        if (i != 21073) {
            return;
        } else {
            diagonal3D = anInt1653 + (int) Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651);
            return;
        }
    }

    public void calculateDiagonals() {
        super.modelHeight = 0;
        anInt1650 = 0;
        anInt1651 = 0;
        for (int i = 0; i < numberOfVerticeCoordinates; i++) {
            int j = verticesXCoordinate[i];
            int k = verticesYCoordinate[i];
            int l = verticesZCoordinate[i];
            if (-k > super.modelHeight)
                super.modelHeight = -k;
            if (k > anInt1651)
                anInt1651 = k;
            int i1 = j * j + l * l;
            if (i1 > anInt1650)
                anInt1650 = i1;
        }
        anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
        anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight)
                + 0.98999999999999999D);
        diagonal3D = anInt1653
                + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
    }

    public void createBones() {
        if (vertexVSkin != null) {
            int ai[] = new int[256];
            int j = 0;
            for (int l = 0; l < numberOfVerticeCoordinates; l++) {
                int j1 = vertexVSkin[l];
                ai[j1]++;
                if (j1 > j)
                    j = j1;
            }
            vertexSkin = null;
            vertexSkin = new int[j + 1][];
            for (int k1 = 0; k1 <= j; k1++) {
                vertexSkin[k1] = new int[ai[k1]];
                ai[k1] = 0;
            }

            for (int j2 = 0; j2 < numberOfVerticeCoordinates; j2++) {
                int l2 = vertexVSkin[j2];
                vertexSkin[l2][ai[l2]++] = j2;
            }

            vertexVSkin = null;
            ai = null;
        }
        if (triangleTSkin != null) {
            int ai1[] = new int[256];
            int k = 0;
            for (int i1 = 0; i1 < numberOfTriangleFaces; i1++) {
                int l1 = triangleTSkin[i1];
                ai1[l1]++;
                if (l1 > k)
                    k = l1;
            }
            triangleSkin = null;
            triangleSkin = new int[k + 1][];
            for (int i2 = 0; i2 <= k; i2++) {
                triangleSkin[i2] = new int[ai1[i2]];
                ai1[i2] = 0;
            }

            for (int k2 = 0; k2 < numberOfTriangleFaces; k2++) {
                int i3 = triangleTSkin[k2];
                triangleSkin[i3][ai1[i3]++] = k2;
            }

            triangleTSkin = null;
            ai1 = null;
        }
    }

    private final boolean cursorOn(int cursorX, int cursorY, int proj_vertex_yA, int proj_vertex_yB, int proj_vertex_yC,
                                   int proj_vertex_xA, int proj_vertex_xB, int proj_vertex_xC) {
        if (cursorY < proj_vertex_yA && cursorY < proj_vertex_yB && cursorY < proj_vertex_yC)
            return false;
        if (cursorY > proj_vertex_yA && cursorY > proj_vertex_yB && cursorY > proj_vertex_yC)
            return false;
        if (cursorX < proj_vertex_xA && cursorX < proj_vertex_xB && cursorX < proj_vertex_xC)
            return false;
        return cursorX <= proj_vertex_xA || cursorX <= proj_vertex_xB || cursorX <= proj_vertex_xC;
    }

    public void filterTriangles() {
        for (int triangleId = 0; triangleId < numberOfTriangleFaces; triangleId++) {
            int l = face_a[triangleId];
            int k1 = face_b[triangleId];
            int j2_ = face_c[triangleId];
            boolean b = true;
            label2:
            for (int triId = 0; triId < numberOfTriangleFaces; triId++) {
                if (triId == triangleId)
                    continue label2;
                if (face_a[triId] == l) {
                    b = false;
                    break label2;
                }
                if (face_b[triId] == k1) {
                    b = false;
                    break label2;
                }
                if (face_c[triId] == j2_) {
                    b = false;
                    break label2;
                }
            }
            if (b) {
                if (face_render_type != null)
                    // face_render_type[triangleId] = -1;
                    face_alpha[triangleId] = 255;

            }
        }
    }

    public void light(int i, int j, int k, int l, int i1, boolean flag) {
        try {
            int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
            int k1 = j * j1 >> 8;
            if (face_shade_a == null) {
                face_shade_a = new int[numberOfTriangleFaces];
                face_shade_b = new int[numberOfTriangleFaces];
                face_shade_c = new int[numberOfTriangleFaces];
            }
            if (super.vertexNormals == null) {
                super.vertexNormals = new VertexNormal[numberOfVerticeCoordinates];
                for (int l1 = 0; l1 < numberOfVerticeCoordinates; l1++)
                    super.vertexNormals[l1] = new VertexNormal();

            }
            for (int i2 = 0; i2 < numberOfTriangleFaces; i2++) {
                if (face_color != null && face_alpha != null) {
                    if (face_color[i2] == 65535 || face_color[i2] == 1 || face_color[i2] == 16705
                            || face_color[i2] == 255)
                        face_alpha[i2] = 255;
                }
                int j2 = face_a[i2];
                int l2 = face_b[i2];
                int i3 = face_c[i2];
                int j3 = verticesXCoordinate[l2] - verticesXCoordinate[j2];
                int k3 = verticesYCoordinate[l2] - verticesYCoordinate[j2];
                int l3 = verticesZCoordinate[l2] - verticesZCoordinate[j2];
                int i4 = verticesXCoordinate[i3] - verticesXCoordinate[j2];
                int j4 = verticesYCoordinate[i3] - verticesYCoordinate[j2];
                int k4 = verticesZCoordinate[i3] - verticesZCoordinate[j2];
                int l4 = k3 * k4 - j4 * l3;
                int i5 = l3 * i4 - k4 * j3;
                int j5;
                for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192
                        || j5 < -8192; j5 >>= 1) {
                    l4 >>= 1;
                    i5 >>= 1;
                }

                int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
                if (k5 <= 0)
                    k5 = 1;
                l4 = (l4 * 256) / k5;
                i5 = (i5 * 256) / k5;
                j5 = (j5 * 256) / k5;

                if (face_render_type == null || (face_render_type[i2] & 1) == 0) {

                    VertexNormal vNormal = super.vertexNormals[j2];
                    vNormal.anInt602 += l4;
                    vNormal.anInt603 += i5;
                    vNormal.anInt604 += j5;
                    vNormal.anInt605++;
                    vNormal = super.vertexNormals[l2];
                    vNormal.anInt602 += l4;
                    vNormal.anInt603 += i5;
                    vNormal.anInt604 += j5;
                    vNormal.anInt605++;
                    vNormal = super.vertexNormals[i3];
                    vNormal.anInt602 += l4;
                    vNormal.anInt603 += i5;
                    vNormal.anInt604 += j5;
                    vNormal.anInt605++;
                    vNormal = null;

                } else {

                    int l5 = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
                    face_shade_a[i2] = method481(face_color[i2], l5, face_render_type[i2]);

                }
            }

            if (flag) {
                method480(i, k1, k, l, i1);
            } else {
                vertexNormalOffset = new VertexNormal[numberOfVerticeCoordinates];
                for (int k2 = 0; k2 < numberOfVerticeCoordinates; k2++) {
                    VertexNormal vNormal = super.vertexNormals[k2];
                    vertexNormalOffset[k2] = new VertexNormal();
                    vertexNormalOffset[k2].anInt602 = vNormal.anInt602;
                    vertexNormalOffset[k2].anInt603 = vNormal.anInt603;
                    vertexNormalOffset[k2].anInt604 = vNormal.anInt604;
                    vertexNormalOffset[k2].anInt605 = vNormal.anInt605;
                }

            }
            if (flag) {
                calculateDiagonals();
                return;
            } else {
                calcDiagonalsAndStats(21073);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void method464(Model model, boolean flag) {
        numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
        numberOfTriangleFaces = model.numberOfTriangleFaces;
        numberOfTexturesFaces = model.numberOfTexturesFaces;
        if (anIntArray1622.length < numberOfVerticeCoordinates) {
            anIntArray1622 = new int[numberOfVerticeCoordinates + 10000];
            anIntArray1623 = new int[numberOfVerticeCoordinates + 10000];
            anIntArray1624 = new int[numberOfVerticeCoordinates + 10000];
        }
        verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = anIntArray1622;
        verticesYCoordinate = anIntArray1623;
        verticesZCoordinate = anIntArray1624;
        for (int k = 0; k < numberOfVerticeCoordinates; k++) {
            verticesParticle[k] = model.verticesParticle[k];
            verticesXCoordinate[k] = model.verticesXCoordinate[k];
            verticesYCoordinate[k] = model.verticesYCoordinate[k];
            verticesZCoordinate[k] = model.verticesZCoordinate[k];
        }

        if (flag) {
            face_alpha = model.face_alpha;
        } else {
            if (anIntArray1625.length < numberOfTriangleFaces)
                anIntArray1625 = new int[numberOfTriangleFaces + 100];
            face_alpha = anIntArray1625;
            if (model.face_alpha == null) {
                for (int l = 0; l < numberOfTriangleFaces; l++)
                    face_alpha[l] = 0;

            } else {
                for (int i1 = 0; i1 < numberOfTriangleFaces; i1++)
                    face_alpha[i1] = model.face_alpha[i1];

            }
        }
        face_render_type = model.face_render_type;
        face_color = model.face_color;
        face_render_priorities = model.face_render_priorities;
        face_priority = model.face_priority;
        triangleSkin = model.triangleSkin;
        vertexSkin = model.vertexSkin;
        face_a = model.face_a;
        face_b = model.face_b;
        face_c = model.face_c;
        face_shade_a = model.face_shade_a;
        face_shade_b = model.face_shade_b;
        face_shade_c = model.face_shade_c;
        textures_face_a = model.textures_face_a;
        textures_face_b = model.textures_face_b;
        textures_face_c = model.textures_face_c;
        texture_coordinates = model.texture_coordinates;
        texture_type = model.texture_type;
        texture = model.texture;
    }

    private final int method465(Model model, int i) {
        int j = -1;
        if (i < 0) return 0;
        int var4 = model.verticesParticle[i];
        int k = model.verticesXCoordinate[i];
        int l = model.verticesYCoordinate[i];
        int i1 = model.verticesZCoordinate[i];
        for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
            if (k != verticesXCoordinate[j1] || l != verticesYCoordinate[j1] || i1 != verticesZCoordinate[j1])
                continue;
            j = j1;
            break;
        }

        if (j == -1) {
            verticesParticle[numberOfVerticeCoordinates] = var4;
            verticesXCoordinate[numberOfVerticeCoordinates] = k;
            verticesYCoordinate[numberOfVerticeCoordinates] = l;
            verticesZCoordinate[numberOfVerticeCoordinates] = i1;
            if (model.vertexVSkin != null)
                vertexVSkin[numberOfVerticeCoordinates] = model.vertexVSkin[i];
            j = numberOfVerticeCoordinates++;
        }
        return j;
    }

    public void method471(int ai[], int j, int k) {
        method471(ai, j, k, DataType.REGULAR);
    }

    public void method471(int ai[], int j, int k, DataType dataType) {
        if (k == -1)
            return;
        if (ai == null || j == -1) {
            applyTransform(k, dataType);
            return;
        }
        FrameReader class36 = FrameReader.forID(k, dataType);
        if (class36 == null)
            return;
        FrameReader class36_1 = FrameReader.forID(j, dataType);
        if (class36_1 == null) {
            applyTransform(k, dataType);
            return;
        }
        SkinList class18 = class36.mySkinList;
        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        int l = 0;
        int i1 = ai[l++];
        for (int j1 = 0; j1 < class36.stepCount; j1++) {
            int k1;
            for (k1 = class36.opCodeLinkTable[j1]; k1 > i1; i1 = ai[l++])
                ;
            if (k1 != i1 || class18.opcodes[k1] == 0)
                method472(class18.opcodes[k1], class18.skinList[k1], class36.xOffset[j1], class36.yOffset[j1],
                        class36.zOffset[j1]);
        }

        anInt1681 = 0;
        anInt1682 = 0;
        anInt1683 = 0;
        l = 0;
        i1 = ai[l++];
        try {
            for (int l1 = 0; l1 < class36_1.stepCount; l1++) {
                int i2;
                for (i2 = class36_1.opCodeLinkTable[l1]; i2 > i1; i1 = ai[l++])
                    ;
                if (i2 == i1 || class18.opcodes[i2] == 0)
                    method472(class18.opcodes[i2], class18.skinList[i2], class36_1.xOffset[l1], class36_1.yOffset[l1],
                            class36_1.zOffset[l1]);
            }
        } catch (Exception e) {
        }

    }

    private void method472(int animationType, int skin[], int xOffset, int yOffset, int zOffset) {

        int i1 = skin.length;
        if (animationType == 0) {
            int j1 = 0;
            anInt1681 = 0;
            anInt1682 = 0;
            anInt1683 = 0;
            for (int k2 = 0; k2 < i1; k2++) {
                int l3 = skin[k2];
                if (l3 < vertexSkin.length) {
                    int ai5[] = vertexSkin[l3];
                    for (int i5 = 0; i5 < ai5.length; i5++) {
                        int j6 = ai5[i5];
                        anInt1681 += verticesXCoordinate[j6];
                        anInt1682 += verticesYCoordinate[j6];
                        anInt1683 += verticesZCoordinate[j6];
                        j1++;
                    }

                }
            }

            if (j1 > 0) {
                anInt1681 = (int) (anInt1681 / j1 + xOffset);
                anInt1682 = (int) (anInt1682 / j1 + yOffset);
                anInt1683 = (int) (anInt1683 / j1 + zOffset);
                return;
            } else {
                anInt1681 = (int) xOffset;
                anInt1682 = (int) yOffset;
                anInt1683 = (int) zOffset;
                return;
            }
        }
        if (animationType == 1) {
            for (int k1 = 0; k1 < i1; k1++) {
                int l2 = skin[k1];
                if (l2 < vertexSkin.length) {
                    int ai1[] = vertexSkin[l2];
                    for (int i4 = 0; i4 < ai1.length; i4++) {
                        int j5 = ai1[i4];
                        verticesXCoordinate[j5] += xOffset;
                        verticesYCoordinate[j5] += yOffset;
                        verticesZCoordinate[j5] += zOffset;
                    }

                }
            }

            return;
        }
        if (animationType == 2) {
            for (int l1 = 0; l1 < i1; l1++) {
                int i3 = skin[l1];
                if (i3 < vertexSkin.length) {
                    int ai2[] = vertexSkin[i3];
                    for (int j4 = 0; j4 < ai2.length; j4++) {
                        int k5 = ai2[j4];
                        verticesXCoordinate[k5] -= anInt1681;
                        verticesYCoordinate[k5] -= anInt1682;
                        verticesZCoordinate[k5] -= anInt1683;
                        //int j, int k, int l
                        if (zOffset != 0) {
                            int j7 = SINE[zOffset];
                            int i8 = COSINE[zOffset];
                            int l8 = verticesYCoordinate[k5] * j7 + verticesXCoordinate[k5] * i8 >> 16;
                            verticesYCoordinate[k5] = verticesYCoordinate[k5] * i8 - verticesXCoordinate[k5] * j7 >> 16;
                            verticesXCoordinate[k5] = l8;
                        }
                        if (xOffset != 0) {
                            int k7 = SINE[xOffset];
                            int j8 = COSINE[xOffset];
                            int i9 = verticesYCoordinate[k5] * j8 - verticesZCoordinate[k5] * k7 >> 16;
                            verticesZCoordinate[k5] = verticesYCoordinate[k5] * k7 + verticesZCoordinate[k5] * j8 >> 16;
                            verticesYCoordinate[k5] = i9;
                        }
                        if (yOffset != 0) {
                            int l7 = SINE[yOffset];
                            int k8 = COSINE[yOffset];
                            int j9 = verticesZCoordinate[k5] * l7 + verticesXCoordinate[k5] * k8 >> 16;
                            verticesZCoordinate[k5] = verticesZCoordinate[k5] * k8 - verticesXCoordinate[k5] * l7 >> 16;
                            verticesXCoordinate[k5] = j9;
                        }
                        verticesXCoordinate[k5] += anInt1681;
                        verticesYCoordinate[k5] += anInt1682;
                        verticesZCoordinate[k5] += anInt1683;
                    }

                }
            }
            return;
        }
        if (animationType == 3) {
            for (int i2 = 0; i2 < i1; i2++) {
                int j3 = skin[i2];
                if (j3 < vertexSkin.length) {
                    int ai3[] = vertexSkin[j3];
                    for (int k4 = 0; k4 < ai3.length; k4++) {
                        int l5 = ai3[k4];
                        verticesXCoordinate[l5] -= anInt1681;
                        verticesYCoordinate[l5] -= anInt1682;
                        verticesZCoordinate[l5] -= anInt1683;
                        verticesXCoordinate[l5] = (int) ((verticesXCoordinate[l5] * xOffset) / 128);
                        verticesYCoordinate[l5] = (int) ((verticesYCoordinate[l5] * yOffset) / 128);
                        verticesZCoordinate[l5] = (int) ((verticesZCoordinate[l5] * zOffset) / 128);
                        verticesXCoordinate[l5] += anInt1681;
                        verticesYCoordinate[l5] += anInt1682;
                        verticesZCoordinate[l5] += anInt1683;
                    }

                }
            }

            return;
        }
        if (animationType == 5 && triangleSkin != null && face_alpha != null) {
            for (int j2 = 0; j2 < i1; j2++) {
                int k3 = skin[j2];
                if (k3 < triangleSkin.length) {
                    int ai4[] = triangleSkin[k3];
                    for (int l4 = 0; l4 < ai4.length; l4++) {
                        int i6 = ai4[l4];
                        face_alpha[i6] += xOffset * 8;
                        if (face_alpha[i6] < 0)
                            face_alpha[i6] = 0;
                        if (face_alpha[i6] > 255)
                            face_alpha[i6] = 255;
                    }

                }
            }

        }
    }

    public void method480(int i, int j, int k, int l, int i1) {
        for (int j1 = 0; j1 < numberOfTriangleFaces; j1++) {
            int k1 = face_a[j1];
            int i2 = face_b[j1];
            int j2 = face_c[j1];
            if (face_render_type == null) {
                int i3 = face_color[j1];
                VertexNormal class33 = super.vertexNormals[k1];
                int k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604)
                        / (j * class33.anInt605);
                face_shade_a[j1] = method481(i3, k2, 0);
                class33 = super.vertexNormals[i2];
                k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
                face_shade_b[j1] = method481(i3, k2, 0);
                class33 = super.vertexNormals[j2];
                k2 = i + (k * class33.anInt602 + l * class33.anInt603 + i1 * class33.anInt604) / (j * class33.anInt605);
                face_shade_c[j1] = method481(i3, k2, 0);
            } else if ((face_render_type[j1] & 1) == 0) {
                int j3 = face_color[j1];
                int k3 = face_render_type[j1];
                VertexNormal class33_1 = super.vertexNormals[k1];
                int l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
                        / (j * class33_1.anInt605);
                face_shade_a[j1] = method481(j3, l2, k3);
                class33_1 = super.vertexNormals[i2];
                l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
                        / (j * class33_1.anInt605);
                face_shade_b[j1] = method481(j3, l2, k3);
                class33_1 = super.vertexNormals[j2];
                l2 = i + (k * class33_1.anInt602 + l * class33_1.anInt603 + i1 * class33_1.anInt604)
                        / (j * class33_1.anInt605);
                face_shade_c[j1] = method481(j3, l2, k3);
            }
        }

        super.vertexNormals = null;
        vertexNormalOffset = null;
        vertexVSkin = null;
        triangleTSkin = null;
        if (face_render_type != null) {
            for (int l1 = 0; l1 < numberOfTriangleFaces; l1++)
                if ((face_render_type[l1] & 2) == 2)
                    return;

        }
        //face_color = null;
    }

    public void mirrorModel() {
        for (int j = 0; j < numberOfVerticeCoordinates; j++)
            verticesZCoordinate[j] = -verticesZCoordinate[j];
        for (int k = 0; k < numberOfTriangleFaces; k++) {
            int l = face_a[k];
            face_a[k] = face_c[k];
            face_c[k] = l;
        }
    }

    public void normalise() {
        super.modelHeight = 0;
        anInt1651 = 0;
        for (int i = 0; i < numberOfVerticeCoordinates; i++) {
            int j = verticesYCoordinate[i];
            if (-j > super.modelHeight)
                super.modelHeight = -j;
            if (j > anInt1651)
                anInt1651 = j;
        }

        anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight)
                + 0.98999999999999999D);
        diagonal3D = anInt1653
                + (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651) + 0.98999999999999999D);
    }

    private final void rasterise(int i) {
        if (outOfReach[i]) {
            reduce(i);
            return;
        }
        int j = face_a[i];
        int k = face_b[i];
        int l = face_c[i];
        Rasterizer.aBoolean1462 = hasAnEdgeToRestrict[i];
        if (face_alpha == null)
            Rasterizer.anInt1465 = 0;
        else
            Rasterizer.anInt1465 = (face_alpha)[i];
        int i1;
        if (face_render_type == null)
            i1 = 0;
        else
            i1 = face_render_type[i] & 3;
        if (i1 == 0) {
            Rasterizer.drawGouraudTriangle(projected_vertex_y[j], projected_vertex_y[k],
                    projected_vertex_y[l], projected_vertex_x[j],
                    projected_vertex_x[k], projected_vertex_x[l],
                    face_shade_a[i], face_shade_b[i], face_shade_c[i], projected_vertex_z[j],
                    projected_vertex_z[k], projected_vertex_z[l]);
            return;
        }
        if (i1 == 1) {
            Rasterizer.drawFlatTriangle(projected_vertex_y[j], projected_vertex_y[k],
                    projected_vertex_y[l], projected_vertex_x[j],
                    projected_vertex_x[k], projected_vertex_x[l],
                    hsl2rgb[face_shade_a[i]], projected_vertex_z[j],
                    projected_vertex_z[k], projected_vertex_z[l]);
            return;
        }
        if (i1 == 2) {
            int j1 = face_render_type[i] >> 2;
            int l1 = textures_face_a[j1];
            int j2 = textures_face_b[j1];
            int l2 = textures_face_c[j1];
            Rasterizer.drawTexturedTriangle(projected_vertex_y[j], projected_vertex_y[k],
                    projected_vertex_y[l], projected_vertex_x[j],
                    projected_vertex_x[k], projected_vertex_x[l],
                    face_shade_a[i], face_shade_b[i], face_shade_c[i],
                    camera_vertex_y[l1], camera_vertex_y[j2],
                    camera_vertex_y[l2], camera_vertex_x[l1],
                    camera_vertex_x[j2], camera_vertex_x[l2],
                    camera_vertex_z[l1], camera_vertex_z[j2],
                    camera_vertex_z[l2], face_color[i], projected_vertex_z[j],
                    projected_vertex_z[k], projected_vertex_z[l]);
            return;
        }
        if (i1 == 3) {
            int k1 = face_render_type[i] >> 2;
            int i2 = textures_face_a[k1];
            int k2 = textures_face_b[k1];
            int i3 = textures_face_c[k1];
            Rasterizer.drawTexturedTriangle(projected_vertex_y[j], projected_vertex_y[k],
                    projected_vertex_y[l], projected_vertex_x[j],
                    projected_vertex_x[k], projected_vertex_x[l],
                    face_shade_a[i], face_shade_a[i], face_shade_a[i],
                    camera_vertex_y[i2], camera_vertex_y[k2],
                    camera_vertex_y[i3], camera_vertex_x[i2],
                    camera_vertex_x[k2], camera_vertex_x[i3],
                    camera_vertex_z[i2], camera_vertex_z[k2],
                    camera_vertex_z[i3], face_color[i], projected_vertex_z[j],
                    projected_vertex_z[k], projected_vertex_z[l]);
        }
    }

    public void read525Model(byte abyte0[], int modelID, DataType dataType) {
        Stream nc1 = new Stream(abyte0);
        Stream nc2 = new Stream(abyte0);
        Stream nc3 = new Stream(abyte0);
        Stream nc4 = new Stream(abyte0);
        Stream nc5 = new Stream(abyte0);
        Stream nc6 = new Stream(abyte0);
        Stream nc7 = new Stream(abyte0);
        nc1.currentOffset = abyte0.length - 23;
        int numVertices = nc1.readUnsignedWord();
        int numTriangles = nc1.readUnsignedWord();
        int numTexTriangles = nc1.readUnsignedByte();

        ModelHeader modelHeader;
        if (dataType == dataType.OLDSCHOOL) {
            modelHeader = modelHeaderOldschool[modelID] = new ModelHeader();
        } else if (dataType == dataType.CUSTOM) {
        	modelHeader = modelHeaderCustom[modelID] = new ModelHeader();
        } else {
            modelHeader = modelHeaderRegular[modelID] = new ModelHeader();
        }

        modelHeader.modelData = abyte0;
        modelHeader.verticeCount = numVertices;
        modelHeader.triangleCount = numTriangles;
        modelHeader.texturedTriangleCount = numTexTriangles;
        int l1 = nc1.readUnsignedByte();
        boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
        boolean bool_78_ = (l1 & 0x2 ^ 0xffffffff) == -3;
        int i2 = nc1.readUnsignedByte();
        int j2 = nc1.readUnsignedByte();
        int k2 = nc1.readUnsignedByte();
        int l2 = nc1.readUnsignedByte();
        int i3 = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        int v = 0;
        int hb = 0;
        int P = 0;
        byte G = 0;
        byte[] x = null;
        byte[] O = null;
        byte[] J = null;
        byte[] F = null;
        byte[] cb = null;
        byte[] gb = null;
        byte[] lb = null;
        int[] ab = null;
        int[] kb = null;
        int[] y = null;
        int[] N = null;
        short[] D = null;
        int[] triangleColours2 = new int[numTriangles];
        if (numTexTriangles > 0) {
            O = new byte[numTexTriangles];
            nc1.currentOffset = 0;
            for (int j5 = 0; j5 < numTexTriangles; j5++) {
                byte byte0 = O[j5] = nc1.readSignedByte();
                if (byte0 == 0)
                    k4++;
                if (byte0 >= 1 && byte0 <= 3)
                    l4++;
                if (byte0 == 2)
                    i5++;
            }
        }
        int k5 = numTexTriangles;
        int l5 = k5;
        k5 += numVertices;
        int i6 = k5;
        if (l1 == 1)
            k5 += numTriangles;
        int j6 = k5;
        k5 += numTriangles;
        int k6 = k5;
        if (i2 == 255)
            k5 += numTriangles;
        int l6 = k5;
        if (k2 == 1)
            k5 += numTriangles;
        int i7 = k5;
        if (i3 == 1)
            k5 += numVertices;
        int j7 = k5;
        if (j2 == 1)
            k5 += numTriangles;
        int k7 = k5;
        k5 += i4;
        int l7 = k5;
        if (l2 == 1)
            k5 += numTriangles * 2;
        int i8 = k5;
        k5 += j4;
        int j8 = k5;
        k5 += numTriangles * 2;
        int k8 = k5;
        k5 += j3;
        int l8 = k5;
        k5 += k3;
        int i9 = k5;
        k5 += l3;
        int j9 = k5;
        k5 += k4 * 6;
        int k9 = k5;
        k5 += l4 * 6;
        int l9 = k5;
        k5 += l4 * 6;
        int i10 = k5;
        k5 += l4;
        int j10 = k5;
        k5 += l4;
        int k10 = k5;
        k5 += l4 + i5 * 2;
        v = numVertices;
        hb = numTriangles;
        P = numTexTriangles;
        this.verticesParticle = new int[numVertices];
        int[] vertexX = new int[numVertices];
        int[] vertexY = new int[numVertices];
        int[] vertexZ = new int[numVertices];
        int[] facePoint1 = new int[numTriangles];
        int[] facePoint2 = new int[numTriangles];
        int[] facePoint3 = new int[numTriangles];
        vertexVSkin = new int[numVertices];
        face_render_type = new int[numTriangles];
        face_render_priorities = new int[numTriangles];
        face_alpha = new int[numTriangles];
        triangleTSkin = new int[numTriangles];
        if (i3 == 1)
            vertexVSkin = new int[numVertices];
        if (bool)
            face_render_type = new int[numTriangles];
        if (i2 == 255)
            face_render_priorities = new int[numTriangles];
        else
            G = (byte) i2;
        if (j2 == 1)
            face_alpha = new int[numTriangles];
        if (k2 == 1)
            triangleTSkin = new int[numTriangles];
        if (l2 == 1)
            D = new short[numTriangles];
        if (l2 == 1 && numTexTriangles > 0)
            x = new byte[numTriangles];
        triangleColours2 = new int[numTriangles];
        int i_115_ = k5;
        int[] texTrianglesPoint1 = null;
        int[] texTrianglesPoint2 = null;
        int[] texTrianglesPoint3 = null;
        if (numTexTriangles > 0) {
            texTrianglesPoint1 = new int[numTexTriangles];
            texTrianglesPoint2 = new int[numTexTriangles];
            texTrianglesPoint3 = new int[numTexTriangles];
            if (l4 > 0) {
                kb = new int[l4];
                N = new int[l4];
                y = new int[l4];
                gb = new byte[l4];
                lb = new byte[l4];
                F = new byte[l4];
            }
            if (i5 > 0) {
                cb = new byte[i5];
                J = new byte[i5];
            }
        }
        nc1.currentOffset = l5;
        nc2.currentOffset = k8;
        nc3.currentOffset = l8;
        nc4.currentOffset = i9;
        nc5.currentOffset = i7;
        int l10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (int k11 = 0; k11 < numVertices; k11++) {
            int l11 = nc1.readUnsignedByte();
            int j12 = 0;
            if ((l11 & 1) != 0)
                j12 = nc2.method421();
            int l12 = 0;
            if ((l11 & 2) != 0)
                l12 = nc3.method421();
            int j13 = 0;
            if ((l11 & 4) != 0)
                j13 = nc4.method421();
            vertexX[k11] = l10 + j12;
            vertexY[k11] = i11 + l12;
            vertexZ[k11] = j11 + j13;
            l10 = vertexX[k11];
            i11 = vertexY[k11];
            j11 = vertexZ[k11];
            if (vertexVSkin != null)
                vertexVSkin[k11] = nc5.readUnsignedByte();
        }
        nc1.currentOffset = j8;
        nc2.currentOffset = i6;
        nc3.currentOffset = k6;
        nc4.currentOffset = j7;
        nc5.currentOffset = l6;
        nc6.currentOffset = l7;
        nc7.currentOffset = i8;
        for (int i12 = 0; i12 < numTriangles; i12++) {
            triangleColours2[i12] = nc1.readUnsignedWord();
            if (l1 == 1) {
                face_render_type[i12] = nc2.readSignedByte();
                if (face_render_type[i12] == 2)
                    triangleColours2[i12] = 65535;
                face_render_type[i12] = 0;
            }
            if (i2 == 255) {
                face_render_priorities[i12] = nc3.readSignedByte();
            }
            if (j2 == 1) {
                face_alpha[i12] = nc4.readSignedByte();
                if (face_alpha[i12] < 0)
                    face_alpha[i12] = (256 + face_alpha[i12]);
            }
            if (k2 == 1)
                triangleTSkin[i12] = nc5.readUnsignedByte();
            if (l2 == 1)
                D[i12] = (short) (nc6.readUnsignedWord() - 1);
            if (x != null)
                if (D[i12] != -1)
                    x[i12] = (byte) (nc7.readUnsignedByte() - 1);
                else
                    x[i12] = -1;
        }
        nc1.currentOffset = k7;
        nc2.currentOffset = j6;
        int k12 = 0;
        int i13 = 0;
        int k13 = 0;
        int l13 = 0;
        for (int i14 = 0; i14 < numTriangles; i14++) {
            int j14 = nc2.readUnsignedByte();
            if (j14 == 1) {
                k12 = nc1.method421() + l13;
                l13 = k12;
                i13 = nc1.method421() + l13;
                l13 = i13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 2) {
                i13 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 3) {
                k12 = k13;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
            if (j14 == 4) {
                int l14 = k12;
                k12 = i13;
                i13 = l14;
                k13 = nc1.method421() + l13;
                l13 = k13;
                facePoint1[i14] = k12;
                facePoint2[i14] = i13;
                facePoint3[i14] = k13;
            }
        }
        nc1.currentOffset = j9;
        nc2.currentOffset = k9;
        nc3.currentOffset = l9;
        nc4.currentOffset = i10;
        nc5.currentOffset = j10;
        nc6.currentOffset = k10;
        for (int k14 = 0; k14 < numTexTriangles; k14++) {
            int i15 = O[k14] & 0xff;
            if (i15 == 0) {
                texTrianglesPoint1[k14] = nc1.readUnsignedWord();
                texTrianglesPoint2[k14] = nc1.readUnsignedWord();
                texTrianglesPoint3[k14] = nc1.readUnsignedWord();
            }
            if (i15 == 1) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
            if (i15 == 2) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
                cb[k14] = nc6.readSignedByte();
                J[k14] = nc6.readSignedByte();
            }
            if (i15 == 3) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                kb[k14] = nc3.readUnsignedWord();
                N[k14] = nc3.readUnsignedWord();
                y[k14] = nc3.readUnsignedWord();
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
        }
        if (i2 != 255) {
            for (int i12 = 0; i12 < numTriangles; i12++)
                face_render_priorities[i12] = i2;
        }
        face_color = triangleColours2;
        numberOfVerticeCoordinates = numVertices;
        numberOfTriangleFaces = numTriangles;
        verticesXCoordinate = vertexX;
        verticesYCoordinate = vertexY;
        verticesZCoordinate = vertexZ;
        face_a = facePoint1;
        face_b = facePoint2;
        face_c = facePoint3;
        filterTriangles();
        convertTexturesTo317(modelID, D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, x);
    }

    public void readNewModel(byte data[], int modelId) {
        Stream nc1 = new Stream(data);
        Stream nc2 = new Stream(data);
        Stream nc3 = new Stream(data);
        Stream nc4 = new Stream(data);
        Stream nc5 = new Stream(data);
        Stream nc6 = new Stream(data);
        Stream nc7 = new Stream(data);
        nc1.currentOffset = data.length - 23;
        numberOfVerticeCoordinates = nc1.readUnsignedWord();
        numberOfTriangleFaces = nc1.readUnsignedWord();
        numberOfTexturesFaces = nc1.readUnsignedByte();
        int flags = nc1.readUnsignedByte();
        int priority_opcode = nc1.readUnsignedByte();
        int alpha_opcode = nc1.readUnsignedByte();
        int tSkin_opcode = nc1.readUnsignedByte();
        int texture_opcode = nc1.readUnsignedByte();
        int vSkin_opcode = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int texture_id = 0;
        int texture_ = 0;
        int texture__ = 0;
        int face;
        face_color = new int[numberOfTriangleFaces];
        if (numberOfTexturesFaces > 0) {
            texture_type = new int[numberOfTexturesFaces];
            nc1.currentOffset = 0;
            for (face = 0; face < numberOfTexturesFaces; face++) {
                int opcode = texture_type[face] = nc1.readSignedByte();
                if (opcode == 0) {
                    texture_id++;
                }

                if (opcode >= 1 && opcode <= 3) {
                    texture_++;
                }
                if (opcode == 2) {
                    texture__++;
                }
            }
        }
        int pos;
        pos = numberOfTexturesFaces;
        int vertexMod_offset = pos;
        pos += numberOfVerticeCoordinates;

        int drawTypeBasePos = pos;
        if (flags == 1)
            pos += numberOfTriangleFaces;

        int faceMeshLink_offset = pos;
        pos += numberOfTriangleFaces;

        int facePriorityBasePos = pos;
        if (priority_opcode == 255)
            pos += numberOfTriangleFaces;

        int tSkinBasePos = pos;
        if (tSkin_opcode == 1)
            pos += numberOfTriangleFaces;

        int vSkinBasePos = pos;
        if (vSkin_opcode == 1)
            pos += numberOfVerticeCoordinates;

        int alphaBasePos = pos;
        if (alpha_opcode == 1)
            pos += numberOfTriangleFaces;

        int faceVPoint_offset = pos;
        pos += i4;

        int textureIdBasePos = pos;
        if (texture_opcode == 1)
            pos += numberOfTriangleFaces * 2;

        int textureBasePos = pos;
        pos += j4;

        int color_offset = pos;
        pos += numberOfTriangleFaces * 2;

        int vertexX_offset = pos;
        pos += j3;

        int vertexY_offset = pos;
        pos += k3;

        int vertexZ_offset = pos;
        pos += l3;

        int mainBuffer_offset = pos;
        pos += texture_id * 6;

        int firstBuffer_offset = pos;
        pos += texture_ * 6;

        int secondBuffer_offset = pos;
        pos += texture_ * 6;

        int thirdBuffer_offset = pos;
        pos += texture_ * 2;

        int fourthBuffer_offset = pos;
        pos += texture_;

        int fifthBuffer_offset = pos;
        pos += texture_ * 2 + texture__ * 2;
        verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = new int[numberOfVerticeCoordinates];
        verticesYCoordinate = new int[numberOfVerticeCoordinates];
        verticesZCoordinate = new int[numberOfVerticeCoordinates];
        face_a = new int[numberOfTriangleFaces];
        face_b = new int[numberOfTriangleFaces];
        face_c = new int[numberOfTriangleFaces];
        if (vSkin_opcode == 1)
            vertexVSkin = new int[numberOfVerticeCoordinates];

        if (flags == 1)
            face_render_type = new int[numberOfTriangleFaces];

        if (priority_opcode == 255)
            face_render_priorities = new int[numberOfTriangleFaces];
        else
            face_priority = (byte) priority_opcode;

        if (alpha_opcode == 1)
            face_alpha = new int[numberOfTriangleFaces];

        if (tSkin_opcode == 1)
            triangleTSkin = new int[numberOfTriangleFaces];

        if (texture_opcode == 1)
            texture = new int[numberOfTriangleFaces];

        if (texture_opcode == 1 && numberOfTexturesFaces > 0)
            texture_coordinates = new int[numberOfTriangleFaces];

        if (numberOfTexturesFaces > 0) {
            textures_face_a = new int[numberOfTexturesFaces];
            textures_face_b = new int[numberOfTexturesFaces];
            textures_face_c = new int[numberOfTexturesFaces];
        }
        nc1.currentOffset = vertexMod_offset;
        nc2.currentOffset = vertexX_offset;
        nc3.currentOffset = vertexY_offset;
        nc4.currentOffset = vertexZ_offset;
        nc5.currentOffset = vSkinBasePos;
        int start_x = 0;
        int start_y = 0;
        int start_z = 0;
        for (int point = 0; point < numberOfVerticeCoordinates; point++) {
            int flag = nc1.readUnsignedByte();
            int x = 0;
            if ((flag & 1) != 0) {
                x = nc2.method421();
            }
            int y = 0;
            if ((flag & 2) != 0) {
                y = nc3.method421();

            }
            int z = 0;
            if ((flag & 4) != 0) {
                z = nc4.method421();
            }

            verticesXCoordinate[point] = start_x + x;
            verticesYCoordinate[point] = start_y + y;
            verticesZCoordinate[point] = start_z + z;
            start_x = verticesXCoordinate[point];
            start_y = verticesYCoordinate[point];
            start_z = verticesZCoordinate[point];

            if (vertexVSkin != null)
                vertexVSkin[point] = nc5.readUnsignedByte();

        }
        nc1.currentOffset = color_offset;
        nc2.currentOffset = drawTypeBasePos;
        nc3.currentOffset = facePriorityBasePos;
        nc4.currentOffset = alphaBasePos;
        nc5.currentOffset = tSkinBasePos;
        nc6.currentOffset = textureIdBasePos;
        nc7.currentOffset = textureBasePos;
        for (face = 0; face < numberOfTriangleFaces; face++) {
            face_color[face] = (short) nc1.readUnsignedWord();
            if (flags == 1) {
                face_render_type[face] = nc2.readSignedByte();
            }
            if (priority_opcode == 255) {
                face_render_priorities[face] = nc3.readSignedByte();
            }
            if (alpha_opcode == 1) {
                face_alpha[face] = nc4.readSignedByte();
                if (face_alpha[face] < 0)
                    face_alpha[face] = (256 + face_alpha[face]);

            }
            if (tSkin_opcode == 1)
                triangleTSkin[face] = nc5.readUnsignedByte();

            if (texture_opcode == 1) {
                texture[face] = (short) (nc6.readUnsignedWord() - 1);
                if (texture[face] >= 0) {
                    if (face_render_type != null) {
                        if (face_render_type[face] < 2 && face_color[face] != 127 && face_color[face] != -27075) {
                            texture[face] = -1;
                        }
                    }
                }
                if (texture[face] != -1)
                    face_color[face] = 127;
            }
            if (texture_coordinates != null && texture[face] != -1) {
                texture_coordinates[face] = (byte) (nc7.readUnsignedByte() - 1);
            }
        }
        nc1.currentOffset = faceVPoint_offset;
        nc2.currentOffset = faceMeshLink_offset;
        int coordinate_a = 0;
        int coordinate_b = 0;
        int coordinate_c = 0;
        int last_coordinate = 0;
        for (face = 0; face < numberOfTriangleFaces; face++) {
            int opcode = nc2.readUnsignedByte();
            if (opcode == 1) {
                coordinate_a = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_a;
                coordinate_b = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_b;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 2) {
                coordinate_b = coordinate_c;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 3) {
                coordinate_a = coordinate_c;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 4) {
                int l14 = coordinate_a;
                coordinate_a = coordinate_b;
                coordinate_b = l14;
                coordinate_c = nc1.method421() + last_coordinate;
                last_coordinate = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
        }
        nc1.currentOffset = mainBuffer_offset;
        nc2.currentOffset = firstBuffer_offset;
        nc3.currentOffset = secondBuffer_offset;
        nc4.currentOffset = thirdBuffer_offset;
        nc5.currentOffset = fourthBuffer_offset;
        nc6.currentOffset = fifthBuffer_offset;
        for (face = 0; face < numberOfTexturesFaces; face++) {
            int opcode = texture_type[face] & 0xff;
            if (opcode == 0) {
                textures_face_a[face] = (short) nc1.readUnsignedWord();
                textures_face_b[face] = (short) nc1.readUnsignedWord();
                textures_face_c[face] = (short) nc1.readUnsignedWord();
            }
            if (opcode == 1) {
                textures_face_a[face] = (short) nc2.readUnsignedWord();
                textures_face_b[face] = (short) nc2.readUnsignedWord();
                textures_face_c[face] = (short) nc2.readUnsignedWord();
            }
            if (opcode == 2) {
                textures_face_a[face] = (short) nc2.readUnsignedWord();
                textures_face_b[face] = (short) nc2.readUnsignedWord();
                textures_face_c[face] = (short) nc2.readUnsignedWord();
            }
            if (opcode == 3) {
                textures_face_a[face] = (short) nc2.readUnsignedWord();
                textures_face_b[face] = (short) nc2.readUnsignedWord();
                textures_face_c[face] = (short) nc2.readUnsignedWord();
            }
        }
        nc1.currentOffset = pos;
        face = nc1.readUnsignedByte();
    }

    public void readOSRSOldModel(byte[] data, int modelId) {
        boolean has_face_type = false;
        boolean has_texture_type = false;
        Stream stream = new Stream(data);
        Stream stream1 = new Stream(data);
        Stream stream2 = new Stream(data);
        Stream stream3 = new Stream(data);
        Stream stream4 = new Stream(data);
        stream.currentOffset = data.length - 18;
        numberOfVerticeCoordinates = stream.readUnsignedWord();
        numberOfTriangleFaces = stream.readUnsignedWord();
        numberOfTexturesFaces = stream.readUnsignedByte();
        int type_opcode = stream.readUnsignedByte();
        int priority_opcode = stream.readUnsignedByte();
        int alpha_opcode = stream.readUnsignedByte();
        int tSkin_opcode = stream.readUnsignedByte();
        int vSkin_opcode = stream.readUnsignedByte();
        int i_254_ = stream.readUnsignedWord();
        int i_255_ = stream.readUnsignedWord();
        int i_256_ = stream.readUnsignedWord();
        int i_257_ = stream.readUnsignedWord();
        int i_258_ = 0;

        int i_259_ = i_258_;
        i_258_ += numberOfVerticeCoordinates;

        int i_260_ = i_258_;
        i_258_ += numberOfTriangleFaces;

        int i_261_ = i_258_;
        if (priority_opcode == 255)
            i_258_ += numberOfTriangleFaces;

        int i_262_ = i_258_;
        if (tSkin_opcode == 1)
            i_258_ += numberOfTriangleFaces;

        int i_263_ = i_258_;
        if (type_opcode == 1)
            i_258_ += numberOfTriangleFaces;

        int i_264_ = i_258_;
        if (vSkin_opcode == 1)
            i_258_ += numberOfVerticeCoordinates;

        int i_265_ = i_258_;
        if (alpha_opcode == 1)
            i_258_ += numberOfTriangleFaces;

        int i_266_ = i_258_;
        i_258_ += i_257_;

        int i_267_ = i_258_;
        i_258_ += numberOfTriangleFaces * 2;

        int i_268_ = i_258_;
        i_258_ += numberOfTexturesFaces * 6;

        int i_269_ = i_258_;
        i_258_ += i_254_;

        int i_270_ = i_258_;
        i_258_ += i_255_;

        int i_271_ = i_258_;
        i_258_ += i_256_;
        verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = new int[numberOfVerticeCoordinates];
        verticesYCoordinate = new int[numberOfVerticeCoordinates];
        verticesZCoordinate = new int[numberOfVerticeCoordinates];
        face_a = new int[numberOfTriangleFaces];
        face_b = new int[numberOfTriangleFaces];
        face_c = new int[numberOfTriangleFaces];
        if (numberOfTexturesFaces > 0) {
            texture_type = new int[numberOfTexturesFaces];
            textures_face_a = new int[numberOfTexturesFaces];
            textures_face_b = new int[numberOfTexturesFaces];
            textures_face_c = new int[numberOfTexturesFaces];
        }

        if (vSkin_opcode == 1)
            vertexVSkin = new int[numberOfVerticeCoordinates];

        if (type_opcode == 1) {
            face_render_type = new int[numberOfTriangleFaces];
            texture_coordinates = new int[numberOfTriangleFaces];
            texture = new int[numberOfTriangleFaces];
        }

        if (priority_opcode == 255)
            face_render_priorities = new int[numberOfTriangleFaces];
        else
            face_priority = (byte) priority_opcode;

        if (alpha_opcode == 1)
            face_alpha = new int[numberOfTriangleFaces];

        if (tSkin_opcode == 1)
            triangleTSkin = new int[numberOfTriangleFaces];

        face_color = new int[numberOfTriangleFaces];
        stream.currentOffset = i_259_;
        stream1.currentOffset = i_269_;
        stream2.currentOffset = i_270_;
        stream3.currentOffset = i_271_;
        stream4.currentOffset = i_264_;
        int start_x = 0;
        int start_y = 0;
        int start_z = 0;
        for (int point = 0; point < numberOfVerticeCoordinates; point++) {
            int flag = stream.readUnsignedByte();
            int x = 0;
            if ((flag & 0x1) != 0)
                x = stream1.method421();
            int y = 0;
            if ((flag & 0x2) != 0)
                y = stream2.method421();
            int z = 0;
            if ((flag & 0x4) != 0)
                z = stream3.method421();

            verticesXCoordinate[point] = start_x + x;
            verticesYCoordinate[point] = start_y + y;
            verticesZCoordinate[point] = start_z + z;
            start_x = verticesXCoordinate[point];
            start_y = verticesYCoordinate[point];
            start_z = verticesZCoordinate[point];
            if (vSkin_opcode == 1)
                vertexVSkin[point] = stream4.readUnsignedByte();

        }
        stream.currentOffset = i_267_;
        stream1.currentOffset = i_263_;
        stream2.currentOffset = i_261_;
        stream3.currentOffset = i_265_;
        stream4.currentOffset = i_262_;
        for (int face = 0; face < numberOfTriangleFaces; face++) {
            face_color[face] = stream.readUnsignedWord();
            if (type_opcode == 1) {
                int flag = stream1.readUnsignedByte();
                if ((flag & 0x1) == 1) {
                    face_render_type[face] = 1;
                    has_face_type = true;
                } else {
                    face_render_type[face] = 0;
                }

                if ((flag & 0x2) != 0) {
                    texture_coordinates[face] = (byte) (flag >> 2);
                    texture[face] = face_color[face];
                    face_color[face] = 127;
                    if (texture[face] != -1)
                        has_texture_type = true;
                } else {
                    texture_coordinates[face] = -1;
                    texture[face] = -1;
                }
            }
            if (priority_opcode == 255)
                face_render_priorities[face] = stream2.readSignedByte();

            if (alpha_opcode == 1) {
                face_alpha[face] = stream3.readSignedByte();
                if (face_alpha[face] < 0)
                    face_alpha[face] = (256 + face_alpha[face]);

            }
            if (tSkin_opcode == 1)
                triangleTSkin[face] = stream4.readUnsignedByte();

        }
        stream.currentOffset = i_266_;
        stream1.currentOffset = i_260_;
        int coordinate_a = 0;
        int coordinate_b = 0;
        int coordinate_c = 0;
        int offset = 0;
        int coordinate;
        for (int face = 0; face < numberOfTriangleFaces; face++) {
            int opcode = stream1.readUnsignedByte();
            if (opcode == 1) {
                coordinate_a = (stream.method421() + offset);
                offset = coordinate_a;
                coordinate_b = (stream.method421() + offset);
                offset = coordinate_b;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 2) {
                coordinate_b = coordinate_c;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 3) {
                coordinate_a = coordinate_c;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
            if (opcode == 4) {
                coordinate = coordinate_a;
                coordinate_a = coordinate_b;
                coordinate_b = coordinate;
                coordinate_c = (stream.method421() + offset);
                offset = coordinate_c;
                face_a[face] = coordinate_a;
                face_b[face] = coordinate_b;
                face_c[face] = coordinate_c;
            }
        }
        stream.currentOffset = i_268_;
        for (int face = 0; face < numberOfTexturesFaces; face++) {
            texture_type[face] = 0;
            textures_face_a[face] = (short) stream.readUnsignedWord();
            textures_face_b[face] = (short) stream.readUnsignedWord();
            textures_face_c[face] = (short) stream.readUnsignedWord();
        }
        if (texture_coordinates != null) {
            boolean textured = false;
            for (int face = 0; face < numberOfTriangleFaces; face++) {
                coordinate = texture_coordinates[face] & 0xff;
                if (coordinate != 255) {
                    if (((textures_face_a[coordinate] & 0xffff) == face_a[face]) && ((textures_face_b[coordinate] & 0xffff) == face_b[face]) && ((textures_face_c[coordinate] & 0xffff) == face_c[face])) {
                        texture_coordinates[face] = -1;
                    } else {
                        textured = true;
                    }
                }
            }
            if (!textured)
                texture_coordinates = null;
        }
        if (!has_texture_type)
            texture = null;

        if (!has_face_type)
            face_render_type = null;
    }

    public void read622Model(byte abyte0[], int modelID, DataType dataType) {
        Stream nc1 = new Stream(abyte0);
        Stream nc2 = new Stream(abyte0);
        Stream nc3 = new Stream(abyte0);
        Stream nc4 = new Stream(abyte0);
        Stream nc5 = new Stream(abyte0);
        Stream nc6 = new Stream(abyte0);
        Stream nc7 = new Stream(abyte0);
        nc1.currentOffset = abyte0.length - 23;
        int numVertices = nc1.readUnsignedWord();
        int numTriangles = nc1.readUnsignedWord();
        int numTexTriangles = nc1.readUnsignedByte();

        ModelHeader modelHeader;
        if(dataType == DataType.OLDSCHOOL) {
            modelHeader = modelHeaderOldschool[modelID] = new ModelHeader();
        } else if (dataType == DataType.OLDSCHOOL) {
        	modelHeader = modelHeaderCustom[modelID] = new ModelHeader();
        } else {
            modelHeader = modelHeaderRegular[modelID] = new ModelHeader();
        }

        modelHeader.modelData = abyte0;
        modelHeader.verticeCount = numVertices;
        modelHeader.triangleCount = numTriangles;
        modelHeader.texturedTriangleCount = numTexTriangles;
        int l1 = nc1.readUnsignedByte();
        boolean bool = (0x1 & l1 ^ 0xffffffff) == -2;
        boolean bool_78_ = (l1 & 0x2 ^ 0xffffffff) == -3;
        boolean bool_25_ = (0x4 & l1) == 4;
        boolean bool_26_ = (0x8 & l1) == 8;
        if (!bool_26_) {
            read525Model(abyte0, modelID, dataType);
            return;
        }
        int newformat = 0;
        if (bool_26_) {
            nc1.currentOffset -= 7;
            newformat = nc1.readUnsignedByte();
            nc1.currentOffset += 6;
        }
        if (newformat == 15)
            newmodel[modelID] = true;
        int i2 = nc1.readUnsignedByte();
        int j2 = nc1.readUnsignedByte();
        int k2 = nc1.readUnsignedByte();
        int l2 = nc1.readUnsignedByte();
        int i3 = nc1.readUnsignedByte();
        int j3 = nc1.readUnsignedWord();
        int k3 = nc1.readUnsignedWord();
        int l3 = nc1.readUnsignedWord();
        int i4 = nc1.readUnsignedWord();
        int j4 = nc1.readUnsignedWord();
        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        int v = 0;
        int hb = 0;
        int P = 0;
        byte G = 0;
        byte[] x = null;
        byte[] O = null;
        byte[] J = null;
        byte[] F = null;
        byte[] cb = null;
        byte[] gb = null;
        byte[] lb = null;
        int[] ab = null;
        int[] kb = null;
        int[] y = null;
        int[] N = null;
        short[] D = null;
        int[] triangleColours2 = new int[numTriangles];
        if (numTexTriangles > 0) {
            O = new byte[numTexTriangles];
            nc1.currentOffset = 0;
            for (int j5 = 0; j5 < numTexTriangles; j5++) {
                byte byte0 = O[j5] = nc1.readSignedByte();
                if (byte0 == 0)
                    k4++;
                if (byte0 >= 1 && byte0 <= 3)
                    l4++;
                if (byte0 == 2)
                    i5++;
            }
        }
        int k5 = numTexTriangles;
        int l5 = k5;
        k5 += numVertices;
        int i6 = k5;
        if (bool)
            k5 += numTriangles;
        if (l1 == 1)
            k5 += numTriangles;
        int j6 = k5;
        k5 += numTriangles;
        int k6 = k5;
        if (i2 == 255)
            k5 += numTriangles;
        int l6 = k5;
        if (k2 == 1)
            k5 += numTriangles;
        int i7 = k5;
        if (i3 == 1)
            k5 += numVertices;
        int j7 = k5;
        if (j2 == 1)
            k5 += numTriangles;
        int k7 = k5;
        k5 += i4;
        int l7 = k5;
        if (l2 == 1)
            k5 += numTriangles * 2;
        int i8 = k5;
        k5 += j4;
        int j8 = k5;
        k5 += numTriangles * 2;
        int k8 = k5;
        k5 += j3;
        int l8 = k5;
        k5 += k3;
        int i9 = k5;
        k5 += l3;
        int j9 = k5;
        k5 += k4 * 6;
        int k9 = k5;
        k5 += l4 * 6;
        int i_59_ = 6;
        if (newformat != 14) {
            if (newformat >= 15)
                i_59_ = 9;
        } else
            i_59_ = 7;
        int l9 = k5;
        k5 += i_59_ * l4;
        int i10 = k5;
        k5 += l4;
        int j10 = k5;
        k5 += l4;
        int k10 = k5;
        k5 += l4 + i5 * 2;
        v = numVertices;
        hb = numTriangles;
        P = numTexTriangles;
        this.verticesParticle = new int[numVertices];
        int[] vertexX = new int[numVertices];
        int[] vertexY = new int[numVertices];
        int[] vertexZ = new int[numVertices];
        int[] facePoint1 = new int[numTriangles];
        int[] facePoint2 = new int[numTriangles];
        int[] facePoint3 = new int[numTriangles];
        vertexVSkin = new int[numVertices];
        face_render_type = new int[numTriangles];
        face_render_priorities = new int[numTriangles];
        face_alpha = new int[numTriangles];
        triangleTSkin = new int[numTriangles];
        if (i3 == 1)
            vertexVSkin = new int[numVertices];
        if (bool)
            face_render_type = new int[numTriangles];
        if (i2 == 255)
            face_render_priorities = new int[numTriangles];
        else
            G = (byte) i2;
        if (j2 == 1)
            face_alpha = new int[numTriangles];
        if (k2 == 1)
            triangleTSkin = new int[numTriangles];
        if (l2 == 1)
            D = new short[numTriangles];
        if (l2 == 1 && numTexTriangles > 0)
            x = new byte[numTriangles];
        triangleColours2 = new int[numTriangles];
        int i_115_ = k5;
        int[] texTrianglesPoint1 = null;
        int[] texTrianglesPoint2 = null;
        int[] texTrianglesPoint3 = null;
        if (numTexTriangles > 0) {
            texTrianglesPoint1 = new int[numTexTriangles];
            texTrianglesPoint2 = new int[numTexTriangles];
            texTrianglesPoint3 = new int[numTexTriangles];
            if (l4 > 0) {
                kb = new int[l4];
                N = new int[l4];
                y = new int[l4];
                gb = new byte[l4];
                lb = new byte[l4];
                F = new byte[l4];
            }
            if (i5 > 0) {
                cb = new byte[i5];
                J = new byte[i5];
            }
        }
        nc1.currentOffset = l5;
        nc2.currentOffset = k8;
        nc3.currentOffset = l8;
        nc4.currentOffset = i9;
        nc5.currentOffset = i7;
        int l10 = 0;
        int i11 = 0;
        int j11 = 0;
        for (int k11 = 0; k11 < numVertices; k11++) {
            int l11 = nc1.readUnsignedByte();
            int j12 = 0;
            if ((l11 & 1) != 0)
                j12 = nc2.method421();
            int l12 = 0;
            if ((l11 & 2) != 0)
                l12 = nc3.method421();
            int j13 = 0;
            if ((l11 & 4) != 0)
                j13 = nc4.method421();
            vertexX[k11] = l10 + j12;
            vertexY[k11] = i11 + l12;
            vertexZ[k11] = j11 + j13;
            l10 = vertexX[k11];
            i11 = vertexY[k11];
            j11 = vertexZ[k11];
            if (vertexVSkin != null)
                vertexVSkin[k11] = nc5.readUnsignedByte();
        }
        nc1.currentOffset = j8;
        nc2.currentOffset = i6;
        nc3.currentOffset = k6;
        nc4.currentOffset = j7;
        nc5.currentOffset = l6;
        nc6.currentOffset = l7;
        nc7.currentOffset = i8;
        for (int i12 = 0; i12 < numTriangles; i12++) {
            triangleColours2[i12] = nc1.readUnsignedWord();
            if (l1 == 1) {
                face_render_type[i12] = nc2.readSignedByte();
                if (face_render_type[i12] == 2)
                    triangleColours2[i12] = 65535;
                face_render_type[i12] = 0;
            }
            if (i2 == 255) {
                face_render_priorities[i12] = nc3.readSignedByte();
            }
            if (j2 == 1) {
                face_alpha[i12] = nc4.readSignedByte();
                if (face_alpha[i12] < 0)
                    face_alpha[i12] = (256 + face_alpha[i12]);
            }
            if (k2 == 1)
                triangleTSkin[i12] = nc5.readUnsignedByte();
            if (l2 == 1)
                D[i12] = (short) (nc6.readUnsignedWord() - 1);
            if (x != null)
                if (D[i12] != -1)
                    x[i12] = (byte) (nc7.readUnsignedByte() - 1);
                else
                    x[i12] = -1;
        }
        nc1.currentOffset = k7;
        nc2.currentOffset = j6;
        int point1 = 0;
        int point2 = 0;
        int point3 = 0;
        int offset = 0;
        for (int i14 = 0; i14 < numTriangles; i14++) {
            int triangleType = nc2.readUnsignedByte();
            if (triangleType == 1) {
                point1 = nc1.method421() + offset;
                offset = point1;
                point2 = nc1.method421() + offset;
                offset = point2;
                point3 = nc1.method421() + offset;
                offset = point3;
                facePoint1[i14] = point1;
                facePoint2[i14] = point2;
                facePoint3[i14] = point3;
            }
            if (triangleType == 2) {
                point2 = point3;
                point3 = nc1.method421() + offset;
                offset = point3;
                facePoint1[i14] = point1;
                facePoint2[i14] = point2;
                facePoint3[i14] = point3;
            }
            if (triangleType == 3) {
                point1 = point3;
                point3 = nc1.method421() + offset;
                offset = point3;
                facePoint1[i14] = point1;
                facePoint2[i14] = point2;
                facePoint3[i14] = point3;
            }
            if (triangleType == 4) {
                int pointOffset = point1;
                point1 = point2;
                point2 = pointOffset;
                point3 = nc1.method421() + offset;
                offset = point3;
                facePoint1[i14] = point1;
                facePoint2[i14] = point2;
                facePoint3[i14] = point3;
            }
        }
        nc1.currentOffset = j9;
        nc2.currentOffset = k9;
        nc3.currentOffset = l9;
        nc4.currentOffset = i10;
        nc5.currentOffset = j10;
        nc6.currentOffset = k10;
        for (int k14 = 0; k14 < numTexTriangles; k14++) {
            int i15 = O[k14] & 0xff;
            if (i15 == 0) {
                texTrianglesPoint1[k14] = nc1.readUnsignedWord();
                texTrianglesPoint2[k14] = nc1.readUnsignedWord();
                texTrianglesPoint3[k14] = nc1.readUnsignedWord();
            }
            if (i15 == 1) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat < 15) {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat >= 14)
                        N[k14] = nc3.v(-1);
                    else
                        N[k14] = nc3.readUnsignedWord();
                    y[k14] = nc3.readUnsignedWord();
                } else {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
            if (i15 == 2) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat >= 15) {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                } else {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat < 14)
                        N[k14] = nc3.readUnsignedWord();
                    else
                        N[k14] = nc3.v(-1);
                    y[k14] = nc3.readUnsignedWord();
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
                cb[k14] = nc6.readSignedByte();
                J[k14] = nc6.readSignedByte();
            }
            if (i15 == 3) {
                texTrianglesPoint1[k14] = nc2.readUnsignedWord();
                texTrianglesPoint2[k14] = nc2.readUnsignedWord();
                texTrianglesPoint3[k14] = nc2.readUnsignedWord();
                if (newformat < 15) {
                    kb[k14] = nc3.readUnsignedWord();
                    if (newformat < 14)
                        N[k14] = nc3.readUnsignedWord();
                    else
                        N[k14] = nc3.v(-1);
                    y[k14] = nc3.readUnsignedWord();
                } else {
                    kb[k14] = nc3.v(-1);
                    N[k14] = nc3.v(-1);
                    y[k14] = nc3.v(-1);
                }
                gb[k14] = nc4.readSignedByte();
                lb[k14] = nc5.readSignedByte();
                F[k14] = nc6.readSignedByte();
            }
        }
        if (i2 != 255) {
            for (int i12 = 0; i12 < numTriangles; i12++)
                face_render_priorities[i12] = i2;
        }
        face_color = triangleColours2;
        numberOfVerticeCoordinates = numVertices;
        numberOfTriangleFaces = numTriangles;
        verticesXCoordinate = vertexX;
        verticesYCoordinate = vertexY;
        verticesZCoordinate = vertexZ;
        face_a = facePoint1;
        face_b = facePoint2;
        face_c = facePoint3;
        filterTriangles();
        convertTexturesTo317(modelID, D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, x);
    }

    private void readOldModel(int i, DataType dataType) {
        int j = -870;
        aBoolean1618 = true;
        rendersWithinOneTile = false;
        anInt1620++;

        ModelHeader header;
        if(dataType == DataType.OLDSCHOOL) {
            header = modelHeaderOldschool[i];
        } else if (dataType == DataType.CUSTOM) {
        	header = modelHeaderCustom[i];
        } else {
            header = modelHeaderRegular[i];
        }

        numberOfVerticeCoordinates = header.verticeCount;
        numberOfTriangleFaces = header.triangleCount;
        numberOfTexturesFaces = header.texturedTriangleCount;
        this.verticesParticle = new int[numberOfVerticeCoordinates];
        verticesXCoordinate = new int[numberOfVerticeCoordinates];
        verticesYCoordinate = new int[numberOfVerticeCoordinates];
        verticesZCoordinate = new int[numberOfVerticeCoordinates];
        face_a = new int[numberOfTriangleFaces];
        face_b = new int[numberOfTriangleFaces];
        while (j >= 0)
            aBoolean1618 = !aBoolean1618;
        face_c = new int[numberOfTriangleFaces];
        textures_face_a = new int[numberOfTexturesFaces];
        textures_face_b = new int[numberOfTexturesFaces];
        textures_face_c = new int[numberOfTexturesFaces];
        if (header.vskinBasePos >= 0)
            vertexVSkin = new int[numberOfVerticeCoordinates];
        if (header.drawTypeBasePos >= 0)
            face_render_type = new int[numberOfTriangleFaces];
        if (header.facePriorityBasePos >= 0)
            face_render_priorities = new int[numberOfTriangleFaces];
        else
            face_priority = -header.facePriorityBasePos - 1;
        if (header.alphaBasepos >= 0)
            face_alpha = new int[numberOfTriangleFaces];
        if (header.tskinBasepos >= 0)
            triangleTSkin = new int[numberOfTriangleFaces];
        face_color = new int[numberOfTriangleFaces];
        Stream stream = new Stream(header.modelData);
        stream.currentOffset = header.verticesModOffset;
        Stream stream_1 = new Stream(header.modelData);
        stream_1.currentOffset = header.verticesXOffset;
        Stream stream_2 = new Stream(header.modelData);
        stream_2.currentOffset = header.verticesYOffset;
        Stream stream_3 = new Stream(header.modelData);
        stream_3.currentOffset = header.verticesZOffset;
        Stream stream_4 = new Stream(header.modelData);
        stream_4.currentOffset = header.vskinBasePos;
        int k = 0;
        int l = 0;
        int i1 = 0;
        for (int j1 = 0; j1 < numberOfVerticeCoordinates; j1++) {
            int k1 = stream.readUnsignedByte();
            int i2 = 0;
            if ((k1 & 1) != 0)
                i2 = stream_1.method421();
            int k2 = 0;
            if ((k1 & 2) != 0)
                k2 = stream_2.method421();
            int i3 = 0;
            if ((k1 & 4) != 0)
                i3 = stream_3.method421();
            verticesXCoordinate[j1] = k + i2;
            verticesYCoordinate[j1] = l + k2;
            verticesZCoordinate[j1] = i1 + i3;
            k = verticesXCoordinate[j1];
            l = verticesYCoordinate[j1];
            i1 = verticesZCoordinate[j1];
            if (vertexVSkin != null)
                vertexVSkin[j1] = stream_4.readUnsignedByte();
        }
        stream.currentOffset = header.triColourOffset;
        stream_1.currentOffset = header.drawTypeBasePos;
        stream_2.currentOffset = header.facePriorityBasePos;
        stream_3.currentOffset = header.alphaBasepos;
        stream_4.currentOffset = header.tskinBasepos;
        for (int l1 = 0; l1 < numberOfTriangleFaces; l1++) {
            face_color[l1] = stream.readUnsignedWord();
            if (face_render_type != null)
                face_render_type[l1] = stream_1.readUnsignedByte();
            if (face_render_priorities != null)
                face_render_priorities[l1] = stream_2.readUnsignedByte();
            if (face_alpha != null) {
                face_alpha[l1] = stream_3.readUnsignedByte();
            }
            if (triangleTSkin != null)
                triangleTSkin[l1] = stream_4.readUnsignedByte();
        }
        stream.currentOffset = header.triVPointOffset;
        stream_1.currentOffset = header.triMeshLinkOffset;
        int j2 = 0;
        int l2 = 0;
        int j3 = 0;
        int k3 = 0;
        for (int l3 = 0; l3 < numberOfTriangleFaces; l3++) {
            int i4 = stream_1.readUnsignedByte();
            if (i4 == 1) {
                j2 = stream.method421() + k3;
                k3 = j2;
                l2 = stream.method421() + k3;
                k3 = l2;
                j3 = stream.method421() + k3;
                k3 = j3;
                face_a[l3] = j2;
                face_b[l3] = l2;
                face_c[l3] = j3;
            }
            if (i4 == 2) {
                j2 = j2;
                l2 = j3;
                j3 = stream.method421() + k3;
                k3 = j3;
                face_a[l3] = j2;
                face_b[l3] = l2;
                face_c[l3] = j3;
            }
            if (i4 == 3) {
                j2 = j3;
                l2 = l2;
                j3 = stream.method421() + k3;
                k3 = j3;
                face_a[l3] = j2;
                face_b[l3] = l2;
                face_c[l3] = j3;
            }
            if (i4 == 4) {
                int k4 = j2;
                j2 = l2;
                l2 = k4;
                j3 = stream.method421() + k3;
                k3 = j3;
                face_a[l3] = j2;
                face_b[l3] = l2;
                face_c[l3] = j3;
            }
        }
        stream.currentOffset = header.textureInfoBasePos;
        for (int j4 = 0; j4 < numberOfTexturesFaces; j4++) {
            textures_face_a[j4] = stream.readUnsignedWord();
            textures_face_b[j4] = stream.readUnsignedWord();
            textures_face_c[j4] = stream.readUnsignedWord();
        }
        // filterTriangles();
    }

    public void forceRecolour(int i, int j) {
        for (int k = 0; k < numberOfTriangleFaces; k++)
            face_color[k] = j;
    }

    public void recolour(int itemId, int editedColor, int originalColor) {
        for (int k = 0; k < numberOfTriangleFaces; k++) {
            if (face_color[k] == editedColor) {
                face_color[k] = originalColor;
            }
        }
    }

    public void recolour(int i, int j) {
        for (int k = 0; k < numberOfTriangleFaces; k++)
            if (face_color[k] == i) {
                face_color[k] = j;
            }
    }

    public void convertTexturesTo317(int modelId, short[] textureIds, int[] texa, int[] texb, int[] texc, byte[] texture_coordinates) {
        int set = 0;
        int set2 = 0;
        int max = Rasterizer.textureAmount;
        if (textureIds != null) {
            textures_face_a = new int[numberOfTriangleFaces];
            textures_face_b = new int[numberOfTriangleFaces];
            textures_face_c = new int[numberOfTriangleFaces];
            for (int i = 0; i < numberOfTriangleFaces; i++) {

                if (textureIds[i] == -1 && face_render_type[i] == 2) {
                    face_color[i] = 65535;
                    face_render_type[i] = 0;
                }

                if (textureIds[i] >= max || textureIds[i] < 0) {
                    face_render_type[i] = 0;
                    continue;
                }

                if (!Rasterizer.textureEnabled[textureIds[i]] || textureIds[i] == 39) {
                    face_render_type[i] = 0;
                    continue;
                }

				/**
				 * Allowing only the infernal cape and its colored versions to
				 * be textured using its textures.
				 */
                if (!ItemDefinition.infernalModels.contains(modelId) && (textureIds[i] >= Rasterizer.infernalTexture && textureIds[i] <= 68)) {
                    continue;
                }

                face_render_type[i] = 2 + set2;
                set2 += 4;
                int a = face_a[i];
                int b = face_b[i];
                int c = face_c[i];
                face_color[i] = textureIds[i];
                int texture_type = -1;

                if (texture_coordinates != null) {
                    texture_type = texture_coordinates[i] & 0xff;
                    if (texture_type != 0xff) {
                        if (texa[texture_type] >= camera_vertex_x.length || texb[texture_type] >= camera_vertex_y.length || texc[texture_type] >= camera_vertex_z.length) {
                            texture_type = -1;
                        }
                    }
                }

                if (texture_type == 0xff) {
                    texture_type = -1;
                }

                textures_face_a[set] = texture_type == -1 ? a : texa[texture_type];
                textures_face_b[set] = texture_type == -1 ? b : texb[texture_type];
                textures_face_c[set++] = texture_type == -1 ? c : texc[texture_type];
            }
            numberOfTexturesFaces = set;
        }
    }

    private final void reduce(int i) {
        if (face_color != null)
            if (face_color[i] == 65535)
                return;

        int j = Rasterizer.textureInt1;
        int k = Rasterizer.textureInt2;
        int l = 0;
        int i1 = face_a[i];
        int j1 = face_b[i];
        int k1 = face_c[i];
        int l1 = camera_vertex_z[i1];
        int i2 = camera_vertex_z[j1];
        int j2 = camera_vertex_z[k1];

        if (l1 >= 50) {
            anIntArray1678[l] = projected_vertex_x[i1];
            anIntArray1679[l] = projected_vertex_y[i1];
            anIntArray1680[l++] = face_shade_a[i];
        } else {
            int k2 = camera_vertex_y[i1];
            int k3 = camera_vertex_x[i1];
            int k4 = face_shade_a[i];
            if (j2 >= 50) {
                int k5 = (50 - l1) * lightDecay[j2 - l1];
                anIntArray1678[l] = j + (k2 + ((camera_vertex_y[k1] - k2) * k5 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (k3 + ((camera_vertex_x[k1] - k3) * k5 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = k4 + ((face_shade_c[i] - k4) * k5 >> 16);
            }
            if (i2 >= 50) {
                int l5 = (50 - l1) * lightDecay[i2 - l1];
                anIntArray1678[l] = j + (k2 + ((camera_vertex_y[j1] - k2) * l5 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (k3 + ((camera_vertex_x[j1] - k3) * l5 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = k4 + ((face_shade_b[i] - k4) * l5 >> 16);
            }
        }
        if (i2 >= 50) {
            anIntArray1678[l] = projected_vertex_x[j1];
            anIntArray1679[l] = projected_vertex_y[j1];
            anIntArray1680[l++] = face_shade_b[i];
        } else {
            int l2 = camera_vertex_y[j1];
            int l3 = camera_vertex_x[j1];
            int l4 = face_shade_b[i];
            if (l1 >= 50) {
                int i6 = (50 - i2) * lightDecay[l1 - i2];
                anIntArray1678[l] = j + (l2 + ((camera_vertex_y[i1] - l2) * i6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (l3 + ((camera_vertex_x[i1] - l3) * i6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = l4 + ((face_shade_a[i] - l4) * i6 >> 16);
            }
            if (j2 >= 50) {
                int j6 = (50 - i2) * lightDecay[j2 - i2];
                anIntArray1678[l] = j + (l2 + ((camera_vertex_y[k1] - l2) * j6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (l3 + ((camera_vertex_x[k1] - l3) * j6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = l4 + ((face_shade_c[i] - l4) * j6 >> 16);
            }
        }
        if (j2 >= 50) {
            anIntArray1678[l] = projected_vertex_x[k1];
            anIntArray1679[l] = projected_vertex_y[k1];
            anIntArray1680[l++] = face_shade_c[i];
        } else {
            int i3 = camera_vertex_y[k1];
            int i4 = camera_vertex_x[k1];
            int i5 = face_shade_c[i];
            if (i2 >= 50) {
                int k6 = (50 - j2) * lightDecay[i2 - j2];
                anIntArray1678[l] = j + (i3 + ((camera_vertex_y[j1] - i3) * k6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (i4 + ((camera_vertex_x[j1] - i4) * k6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = i5 + ((face_shade_b[i] - i5) * k6 >> 16);
            }
            if (l1 >= 50) {
                int l6 = (50 - j2) * lightDecay[l1 - j2];
                anIntArray1678[l] = j + (i3 + ((camera_vertex_y[i1] - i3) * l6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1679[l] = k + (i4 + ((camera_vertex_x[i1] - i4) * l6 >> 16) << WorldController.viewDistance) / 50;
                anIntArray1680[l++] = i5 + ((face_shade_a[i] - i5) * l6 >> 16);
            }
        }
        int j3 = anIntArray1678[0];
        int j4 = anIntArray1678[1];
        int j5 = anIntArray1678[2];
        int i7 = anIntArray1679[0];
        int j7 = anIntArray1679[1];
        int k7 = anIntArray1679[2];
        if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
            Rasterizer.aBoolean1462 = false;
            if (l == 3) {
                if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
                        || j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX)
                    Rasterizer.aBoolean1462 = true;
                int l7;
                if (face_render_type == null)
                    l7 = 0;
                else
                    l7 = face_render_type[i] & 3;
                if (l7 == 0)
                    Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
                            anIntArray1680[0], anIntArray1680[1],
                            anIntArray1680[2], -1, -1, -1);
                else if (l7 == 1)
                    Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5,
                            hsl2rgb[face_shade_a[i]], -1, -1, -1);
                else if (l7 == 2) {
                    int j8 = face_render_type[i] >> 2;
                    int k9 = textures_face_a[j8];
                    int k10 = textures_face_b[j8];
                    int k11 = textures_face_c[j8];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
                            anIntArray1680[0], anIntArray1680[1],
                            anIntArray1680[2], camera_vertex_y[k9],
                            camera_vertex_y[k10], camera_vertex_y[k11],
                            camera_vertex_x[k9], camera_vertex_x[k10],
                            camera_vertex_x[k11], camera_vertex_z[k9],
                            camera_vertex_z[k10], camera_vertex_z[k11],
                            face_color[i], -1, -1, -1);
                } else if (l7 == 3) {
                    int k8 = face_render_type[i] >> 2;
                    int l9 = textures_face_a[k8];
                    int l10 = textures_face_b[k8];
                    int l11 = textures_face_c[k8];
                    Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
                            face_shade_a[i], face_shade_a[i], face_shade_a[i],
                            camera_vertex_y[l9], camera_vertex_y[l10],
                            camera_vertex_y[l11], camera_vertex_x[l9],
                            camera_vertex_x[l10], camera_vertex_x[l11],
                            camera_vertex_z[l9], camera_vertex_z[l10],
                            camera_vertex_z[l11], face_color[i], -1, -1, -1);
                }
                if (l == 4) {
                    if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.viewportRX
                            || j4 > DrawingArea.viewportRX || j5 > DrawingArea.viewportRX
                            || anIntArray1678[3] < 0
                            || anIntArray1678[3] > DrawingArea.viewportRX)
                        Rasterizer.aBoolean1462 = true;
                    int i8;
                    if (face_render_type == null)
                        i8 = 0;
                    else
                        i8 = face_render_type[i] & 3;
                    if (i8 == 0) {
                        Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5,
                                anIntArray1680[0], anIntArray1680[1],
                                anIntArray1680[2], -1, -1, -1);
                        Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5,
                                anIntArray1678[3], anIntArray1680[0],
                                anIntArray1680[2], anIntArray1680[3], -1, -1, -1);
                        return;
                    }
                    if (i8 == 1) {
                        int l8 = hsl2rgb[face_shade_a[i]];
                        Rasterizer.drawFlatTriangle(i7, j7, k7, j3, j4, j5, l8, -1, -1, -1);
                        Rasterizer.drawFlatTriangle(i7, k7, anIntArray1679[3], j3, j5,
                                anIntArray1678[3], l8, -1, -1, -1);
                        return;
                    }
                    if (i8 == 2) {
                        int i9 = face_render_type[i] >> 2;
                        int i10 = textures_face_a[i9];
                        int i11 = textures_face_b[i9];
                        int i12 = textures_face_c[i9];

                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
                                anIntArray1680[0], anIntArray1680[1],
                                anIntArray1680[2], camera_vertex_y[i10],
                                camera_vertex_y[i11], camera_vertex_y[i12],
                                camera_vertex_x[i10], camera_vertex_x[i11],
                                camera_vertex_x[i12], camera_vertex_z[i10],
                                camera_vertex_z[i11], camera_vertex_z[i12],
                                face_color[i], -1, -1, -1);
                        Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5,
                                anIntArray1678[3], anIntArray1680[0],
                                anIntArray1680[2], anIntArray1680[3],
                                camera_vertex_y[i10], camera_vertex_y[i11],
                                camera_vertex_y[i12], camera_vertex_x[i10],
                                camera_vertex_x[i11], camera_vertex_x[i12],
                                camera_vertex_z[i10], camera_vertex_z[i11],
                                camera_vertex_z[i12], face_color[i], -1, -1, -1);
                        return;
                    }
                    if (i8 == 3) {
                        int j9 = face_render_type[i] >> 2;
                        int j10 = textures_face_a[j9];
                        int j11 = textures_face_b[j9];
                        int j12 = textures_face_c[j9];
                        Rasterizer.drawTexturedTriangle(i7, j7, k7, j3, j4, j5,
                                face_shade_a[i], face_shade_a[i], face_shade_a[i],
                                camera_vertex_y[j10], camera_vertex_y[j11],
                                camera_vertex_y[j12], camera_vertex_x[j10],
                                camera_vertex_x[j11], camera_vertex_x[j12],
                                camera_vertex_z[j10], camera_vertex_z[j11],
                                camera_vertex_z[j12], face_color[i], -1, -1, -1);
                        Rasterizer.drawTexturedTriangle(i7, k7, anIntArray1679[3], j3, j5,
                                anIntArray1678[3], face_shade_a[i],
                                face_shade_a[i], face_shade_a[i],
                                camera_vertex_y[j10], camera_vertex_y[j11],
                                camera_vertex_y[j12], camera_vertex_x[j10],
                                camera_vertex_x[j11], camera_vertex_x[j12],
                                camera_vertex_z[j10], camera_vertex_z[j11],
                                camera_vertex_z[j12], face_color[i], -1, -1, -1);
                    }
                }
            }
        }
    }

    public void renderAtPoint(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int id) {
        renderAtPointX = j1 + Client.instance.xCameraPos;
        renderAtPointY = l1 + Client.instance.yCameraPos;
        renderAtPointZ = k1 + Client.instance.zCameraPos;
        lastRenderedRotation = i;
        int j2 = l1 * i1 - j1 * l >> 16;
        int k2 = k1 * j + j2 * k >> 16;
        int l2 = anInt1650 * k >> 16;
        int i3 = k2 + l2;

        if (i3 <= 50 || k2 >= DRAW_DISTANCE)
            return;
        int j3 = l1 * l + j1 * i1 >> 16;
        int k3 = j3 - anInt1650 << WorldController.viewDistance;
        if (k3 / i3 >= DrawingArea.viewport_centerX)
            return;
        int l3 = j3 + anInt1650 << WorldController.viewDistance;
        if (l3 / i3 <= -DrawingArea.viewport_centerX)
            return;
        int i4 = k1 * k - j2 * j >> 16;
        int j4 = anInt1650 * j >> 16;
        int k4 = i4 + j4 << WorldController.viewDistance;
        if (k4 / i3 <= -DrawingArea.viewport_centerY)
            return;
        int l4 = j4 + (super.modelHeight * k >> 16);
        int i5 = i4 - l4 << WorldController.viewDistance;
        if (i5 / i3 >= DrawingArea.viewport_centerY)
            return;
        int j5 = l2 + (super.modelHeight * j >> 16);
        boolean flag = false;
        if (k2 - j5 <= 50)
            flag = true;
        boolean flag1 = false;
        if (i2 > 0 && objectExists) {
            int k5 = k2 - l2;
            if (k5 <= 50)
                k5 = 50;
            if (j3 > 0) {
                k3 /= i3;
                l3 /= k5;
            } else {
                l3 /= i3;
                k3 /= k5;
            }
            if (i4 > 0) {
                i5 /= i3;
                k4 /= k5;
            } else {
                k4 /= i3;
                i5 /= k5;
            }
            int i6 = currentCursorX - Rasterizer.textureInt1;
            int k6 = currentCursorY - Rasterizer.textureInt2;
            if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
                if (rendersWithinOneTile) {
                    mapObjectIds[objectsRendered] = id;
                    objectsInCurrentRegion[objectsRendered++] = i2;
                } else
                    flag1 = true;
        }
        int l5 = Rasterizer.textureInt1;
        int j6 = Rasterizer.textureInt2;
        int l6 = 0;
        int i7 = 0;
        if (i != 0) {
            l6 = SINE[i];
            i7 = COSINE[i];
        }
        for (int j7 = 0; j7 < numberOfVerticeCoordinates; j7++) {
            int k7 = verticesXCoordinate[j7];
            int l7 = verticesYCoordinate[j7];
            int i8 = verticesZCoordinate[j7];
            if (i != 0) {
                int j8 = i8 * l6 + k7 * i7 >> 16;
                i8 = i8 * i7 - k7 * l6 >> 16;
                k7 = j8;
            }
            k7 += j1;
            l7 += k1;
            i8 += l1;
            int k8 = i8 * l + k7 * i1 >> 16;
            i8 = i8 * i1 - k7 * l >> 16;
            k7 = k8;
            k8 = l7 * k - i8 * j >> 16;
            i8 = l7 * j + i8 * k >> 16;
            l7 = k8;
            anIntArray1667[j7] = i8 - k2;
            if (i8 >= 50) {
                projected_vertex_x[j7] = l5 + (k7 << WorldController.viewDistance) / i8;
                projected_vertex_y[j7] = j6 + (l7 << WorldController.viewDistance) / i8;
                projected_vertex_z[j7] = i8;
            } else {
                projected_vertex_x[j7] = -5000;
                flag = true;
            }
            if (flag || numberOfTexturesFaces > 0) {
                camera_vertex_y[j7] = k7;
                camera_vertex_x[j7] = l7;
                camera_vertex_z[j7] = i8;
            }
        }

        try {
            translateToScreen(flag, flag1, i2, id);
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void renderSingle(int rotation_2, int offsetX, int rotation_1, int offsetY, int zoom_sine, int zoom_cosine) {
        try {
            int i = 0;
            int base_draw_x = Rasterizer.textureInt1;
            int base_draw_y = Rasterizer.textureInt2;
            int base_sine = SINE[i];
            int base_cosine = COSINE[i];
            int rot_2_sine = SINE[rotation_2];
            int rot_2_cosine = COSINE[rotation_2];
            int offsetX_sine = SINE[offsetX];
            int offsetX_cosine = COSINE[offsetX];
            int rot_1_sine = SINE[rotation_1];
            int rot_1_cosine = COSINE[rotation_1];
            int calculated_zoom = zoom_sine * rot_1_sine + zoom_cosine * rot_1_cosine >> 16;
            for (int vertexId = 0; vertexId < numberOfVerticeCoordinates; vertexId++) {
                int baseVertexX = verticesXCoordinate[vertexId];
                int baseVertexY = verticesYCoordinate[vertexId];
                int baseVertexZ = verticesZCoordinate[vertexId];
                if (offsetX != 0) {
                    int calculatedVertexX = baseVertexY * offsetX_sine + baseVertexX * offsetX_cosine >> 16;
                    baseVertexY = baseVertexY * offsetX_cosine - baseVertexX * offsetX_sine >> 16;
                    baseVertexX = calculatedVertexX;
                }
                if (i != 0) {
                    int calculatedVertexY = baseVertexY * base_cosine - baseVertexZ * base_sine >> 16;
                    baseVertexZ = baseVertexY * base_sine + baseVertexZ * base_cosine >> 16;
                    baseVertexY = calculatedVertexY;
                }
                if (rotation_2 != 0) {
                    int calculatedVertexZ = baseVertexZ * rot_2_sine + baseVertexX * rot_2_cosine >> 16;
                    baseVertexZ = baseVertexZ * rot_2_cosine - baseVertexX * rot_2_sine >> 16;
                    baseVertexX = calculatedVertexZ;
                }
                baseVertexX += offsetY;
                baseVertexY += zoom_sine;
                baseVertexZ += zoom_cosine;
                int j6 = baseVertexY * rot_1_cosine - baseVertexZ * rot_1_sine >> 16;
                baseVertexZ = baseVertexY * rot_1_sine + baseVertexZ * rot_1_cosine >> 16;
                baseVertexY = j6;
                anIntArray1667[vertexId] = baseVertexZ - calculated_zoom;
                projected_vertex_x[vertexId] = base_draw_x + (baseVertexX << 9) / baseVertexZ;
                projected_vertex_y[vertexId] = base_draw_y + (baseVertexY << 9) / baseVertexZ;
                projected_vertex_z[vertexId] = baseVertexZ;
                if (numberOfTexturesFaces > 0) {
                    camera_vertex_y[vertexId] = baseVertexX;
                    camera_vertex_x[vertexId] = baseVertexY;
                    camera_vertex_z[vertexId] = baseVertexZ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            translateToScreen(false, false, 0, -1);
            return;
        } catch (Exception _ex) {
            return;
        }
    }

    public void reset() {
        verticesXCoordinate = null;
        verticesYCoordinate = null;
        verticesZCoordinate = null;
        face_a = null;
        face_b = null;
        face_c = null;
        face_shade_a = null;
        face_shade_b = null;
        face_shade_c = null;
        face_render_type = null;
        face_render_priorities = null;
        face_alpha = null;
        face_color = null;
        textures_face_a = textures_face_b = textures_face_c = null;
        vertexVSkin = null;
        triangleTSkin = null;
        vertexSkin = null;
        triangleSkin = null;
        vertexNormalOffset = null;
    }

    public void rotateBy90() {
        for (int j = 0; j < numberOfVerticeCoordinates; j++) {
            int k = verticesXCoordinate[j];
            verticesXCoordinate[j] = verticesZCoordinate[j];
            verticesZCoordinate[j] = -k;
        }
    }

    public void rotateX(int i) {
        int k = SINE[i];
        int l = COSINE[i];
        for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
            int j1 = verticesYCoordinate[i1] * l - verticesZCoordinate[i1] * k >> 16;
            verticesZCoordinate[i1] = verticesYCoordinate[i1] * k + verticesZCoordinate[i1] * l >> 16;
            verticesYCoordinate[i1] = j1;
        }
    }

    public void scale2(int i, int j, int k) {
        for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
            verticesXCoordinate[i1] = verticesXCoordinate[i1] * i >> 7;
            verticesYCoordinate[i1] = verticesYCoordinate[i1] * j >> 7;
            verticesZCoordinate[i1] = verticesZCoordinate[i1] * k >> 7;
        }
    }

    public void scaleT(int i, int j, int l) {
        for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
            verticesXCoordinate[i1] = (verticesXCoordinate[i1] * i) / 128;
            verticesYCoordinate[i1] = (verticesYCoordinate[i1] * l) / 128;
            verticesZCoordinate[i1] = (verticesZCoordinate[i1] * j) / 128;
        }

    }

    public void translate(int i, int j, int l) {
        for (int i1 = 0; i1 < numberOfVerticeCoordinates; i1++) {
            verticesXCoordinate[i1] += i;
            verticesYCoordinate[i1] += j;
            verticesZCoordinate[i1] += l;
        }
    }

    private final void translateToScreen(boolean flag, boolean needAddToSelectedObjects, int i, int id) {
        if (Client.RENDER_DEBUG) {
            needAddToSelectedObjects = true;
        }
        for (int j = 0; j < diagonal3D; j++)
            depthListIndices[j] = 0;

        // filterTriangles();
        for (int triangleId = 0; triangleId < numberOfTriangleFaces; triangleId++) {
            if (face_render_type != null && face_render_type[triangleId] == -1
                    || face_alpha != null && face_alpha[triangleId] >= 255)
                continue;
            int face_a_pos = face_a[triangleId];
            int face_b_pos = face_b[triangleId];
            int face_c_pos = face_c[triangleId];

            int vertexXA = projected_vertex_x[face_a_pos];
            int vertexXB = projected_vertex_x[face_b_pos];
            int vertexXC = projected_vertex_x[face_c_pos];
            if (flag && (vertexXA == -5000 || vertexXB == -5000 || vertexXC == -5000)) {
                outOfReach[triangleId] = true;
                int j5 = (anIntArray1667[face_a_pos] + anIntArray1667[face_b_pos] + anIntArray1667[face_c_pos]) / 3
                        + anInt1653;
                faceLists[j5][depthListIndices[j5]++] = triangleId;
                continue;
            }
            if (needAddToSelectedObjects && cursorOn(currentCursorX, currentCursorY, projected_vertex_y[face_a_pos],
                    projected_vertex_y[face_b_pos], projected_vertex_y[face_c_pos], vertexXA, vertexXB, vertexXC)) {
                mapObjectIds[objectsRendered] = id;
                objectsInCurrentRegion[objectsRendered++] = i;
                needAddToSelectedObjects = false;
            }
            if ((vertexXA - vertexXB) * (projected_vertex_y[face_c_pos] - projected_vertex_y[face_b_pos])
                    - (projected_vertex_y[face_a_pos] - projected_vertex_y[face_b_pos]) * (vertexXC - vertexXB) > 0) {
                outOfReach[triangleId] = false;
                hasAnEdgeToRestrict[triangleId] = vertexXA < 0 || vertexXB < 0 || vertexXC < 0
                        || vertexXA > DrawingArea.viewportRX || vertexXB > DrawingArea.viewportRX
                        || vertexXC > DrawingArea.viewportRX;
                int k5 = (anIntArray1667[face_a_pos] + anIntArray1667[face_b_pos] + anIntArray1667[face_c_pos]) / 3
                        + anInt1653;
                faceLists[k5][depthListIndices[k5]++] = triangleId;
            }
        }

        if (face_render_priorities == null) {
            for (int i1 = diagonal3D - 1; i1 >= 0; i1--) {
                int l1 = depthListIndices[i1];
                if (l1 > 0) {
                    int ai[] = faceLists[i1];
                    for (int j3 = 0; j3 < l1; j3++)
                        rasterise(ai[j3]);

                }
            }

            return;
        }
        for (int j1 = 0; j1 < 12; j1++) {
            anIntArray1673[j1] = 0;
            anIntArray1677[j1] = 0;
        }

        for (int i2 = diagonal3D - 1; i2 >= 0; i2--) {
            int k2 = depthListIndices[i2];
            if (k2 > 0) {
                int ai1[] = faceLists[i2];
                for (int i4 = 0; i4 < k2; i4++) {
                    int l4 = ai1[i4];
                    int l5 = face_render_priorities[l4];
                    int j6 = anIntArray1673[l5]++;
                    anIntArrayArray1674[l5][j6] = l4;
                    if (l5 < 10)
                        anIntArray1677[l5] += i2;
                    else if (l5 == 10)
                        anIntArray1675[j6] = i2;
                    else
                        anIntArray1676[j6] = i2;
                }

            }
        }

        int l2 = 0;
        if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
            l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
        int k3 = 0;
        if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
            k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
        int j4 = 0;
        if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
            j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);
        int i6 = 0;
        int k6 = anIntArray1673[10];
        int ai2[] = anIntArrayArray1674[10];
        int ai3[] = anIntArray1675;
        if (i6 == k6) {
            i6 = 0;
            k6 = anIntArray1673[11];
            ai2 = anIntArrayArray1674[11];
            ai3 = anIntArray1676;
        }
        int i5;
        if (i6 < k6)
            i5 = ai3[i6];
        else
            i5 = -1000;
        for (int l6 = 0; l6 < 10; l6++) {
            while (l6 == 0 && i5 > l2) {
                rasterise(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 3 && i5 > k3) {
                rasterise(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            while (l6 == 5 && i5 > j4) {
                rasterise(ai2[i6++]);
                if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                    i6 = 0;
                    k6 = anIntArray1673[11];
                    ai2 = anIntArrayArray1674[11];
                    ai3 = anIntArray1676;
                }
                if (i6 < k6)
                    i5 = ai3[i6];
                else
                    i5 = -1000;
            }
            int i7 = anIntArray1673[l6];
            int ai4[] = anIntArrayArray1674[l6];
            for (int j7 = 0; j7 < i7; j7++)
                rasterise(ai4[j7]);

        }

        while (i5 != -1000) {
            rasterise(ai2[i6++]);
            if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
                i6 = 0;
                ai2 = anIntArrayArray1674[11];
                k6 = anIntArray1673[11];
                ai3 = anIntArray1676;
            }
            if (i6 < k6)
                i5 = ai3[i6];
            else
                i5 = -500;
        }

        if (Configuration.enableParticles) {

            for (int vertex = 0; vertex < numberOfVerticeCoordinates; ++vertex) {
                int pid = verticesParticle[vertex] - 1;
                if (pid >= 0) {
                    ParticleDefinition def = ParticleDefinition.cache[pid];
                    int x = verticesXCoordinate[vertex];
                    int y = verticesYCoordinate[vertex];
                    int z = verticesZCoordinate[vertex];
                    int depth = projected_vertex_z[vertex];
                    if (lastRenderedRotation != 0) {
                        int sine = SINE[lastRenderedRotation];
                        int cosine = COSINE[lastRenderedRotation];
                        int rotatedX = z * sine + x * cosine >> 16;
                        z = z * cosine - x * sine >> 16;
                        x = rotatedX;
                    }
                    x += renderAtPointX;
                    z += renderAtPointY;

                    ParticleVector pos = new ParticleVector(x, -y, z);

                    for (int p = 0; p < def.getSpawnRate(); p++) {
                        Particle particle = new Particle(def, pos, depth, pid);
                        Client.instance.addParticle(particle);
                    }
                }
            }
        }
    }
}
